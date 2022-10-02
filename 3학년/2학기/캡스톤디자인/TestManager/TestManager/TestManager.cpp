// TestManager.cpp : 애플리케이션에 대한 진입점을 정의합니다.
//

#include "framework.h"
#include "TestManager.h"
#include "ProcessManager.h"
#include "ControlManager.h"
#include <TlHelp32.h>

#define MAX_LOADSTRING 100

// 전역 변수:
HINSTANCE hInst;                                // 현재 인스턴스입니다.
WCHAR szTitle[MAX_LOADSTRING];                  // 제목 표시줄 텍스트입니다.
WCHAR szWindowClass[MAX_LOADSTRING];            // 기본 창 클래스 이름입니다.

/// 주요 인스턴스 생성
ControlManager *g_controlManager;
ProcessManager *g_processManager;


// 이 코드 모듈에 포함된 함수의 선언을 전달합니다:
ATOM                MyRegisterClass(HINSTANCE hInstance);
BOOL                InitInstance(HINSTANCE, int);
LRESULT CALLBACK    WndProc(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    About(HWND, UINT, WPARAM, LPARAM);

int APIENTRY wWinMain(_In_ HINSTANCE hInstance,
                     _In_opt_ HINSTANCE hPrevInstance,
                     _In_ LPWSTR    lpCmdLine,
                     _In_ int       nCmdShow)
{
    UNREFERENCED_PARAMETER(hPrevInstance);
    UNREFERENCED_PARAMETER(lpCmdLine);
	LPWSTR myProcess;
	int killCnt;

	/// 시작 인수의 값을 문자열에서 숫자로 변환하여 획득
	killCnt = _wtoi(lpCmdLine);
	/// 프로세스 전체 경로 획득
	myProcess = GetCommandLine();

	/// 제어 객체 생성
	g_controlManager = new ControlManager(myProcess, killCnt);
	/// 프로세스 객체 생성
	g_processManager = new ProcessManager(g_controlManager);

    // 전역 문자열을 초기화합니다.
    LoadStringW(hInstance, IDS_APP_TITLE, szTitle, MAX_LOADSTRING);
    LoadStringW(hInstance, IDC_TESTMANAGER, szWindowClass, MAX_LOADSTRING);
    MyRegisterClass(hInstance);

    // 애플리케이션 초기화를 수행합니다:
    if (!InitInstance (hInstance, nCmdShow))
    {
        return FALSE;
    }

    HACCEL hAccelTable = LoadAccelerators(hInstance, MAKEINTRESOURCE(IDC_TESTMANAGER));

    MSG msg;

    // 기본 메시지 루프입니다:
    while (GetMessage(&msg, nullptr, 0, 0))
    {
        if (!TranslateAccelerator(msg.hwnd, hAccelTable, &msg))
        {
            TranslateMessage(&msg);
            DispatchMessage(&msg);
        }
    }

    return (int) msg.wParam;
}



//
//  함수: MyRegisterClass()
//
//  용도: 창 클래스를 등록합니다.
//
ATOM MyRegisterClass(HINSTANCE hInstance)
{
    WNDCLASSEXW wcex;

    wcex.cbSize = sizeof(WNDCLASSEX);

    wcex.style          = CS_HREDRAW | CS_VREDRAW;
    wcex.lpfnWndProc    = WndProc;
    wcex.cbClsExtra     = 0;
    wcex.cbWndExtra     = 0;
    wcex.hInstance      = hInstance;
    wcex.hIcon          = LoadIcon(hInstance, MAKEINTRESOURCE(IDI_TESTMANAGER));
    wcex.hCursor        = LoadCursor(nullptr, IDC_ARROW);
    wcex.hbrBackground  = (HBRUSH)(COLOR_WINDOW+1);
    wcex.lpszMenuName   = MAKEINTRESOURCEW(IDC_TESTMANAGER);
    wcex.lpszClassName  = szWindowClass;
    wcex.hIconSm        = LoadIcon(wcex.hInstance, MAKEINTRESOURCE(IDI_SMALL));

    return RegisterClassExW(&wcex);
}

//
//   함수: InitInstance(HINSTANCE, int)
//
//   용도: 인스턴스 핸들을 저장하고 주 창을 만듭니다.
//
//   주석:
//
//        이 함수를 통해 인스턴스 핸들을 전역 변수에 저장하고
//        주 프로그램 창을 만든 다음 표시합니다.
//
BOOL InitInstance(HINSTANCE hInstance, int nCmdShow)
{
   hInst = hInstance; // 인스턴스 핸들을 전역 변수에 저장합니다.
   
   HWND hWnd = CreateWindowW(szWindowClass, szTitle, WS_OVERLAPPEDWINDOW&~WS_MAXIMIZEBOX&~WS_SIZEBOX,
	   500, 50, 660, 200, nullptr, nullptr, hInstance, nullptr);
      //CW_USEDEFAULT, 0, CW_USEDEFAULT, 0, nullptr, nullptr, hInstance, nullptr);

   if (!hWnd)
   {
      return FALSE;
   }

   ShowWindow(hWnd, nCmdShow);
   UpdateWindow(hWnd);

   return TRUE;
}

//
//  함수: WndProc(HWND, UINT, WPARAM, LPARAM)
//
//  용도: 주 창의 메시지를 처리합니다.
//
//  WM_COMMAND  - 애플리케이션 메뉴를 처리합니다.
//  WM_PAINT    - 주 창을 그립니다.
//  WM_DESTROY  - 종료 메시지를 게시하고 반환합니다.
//
//

// 시험 시작 버튼 ID
#define EXAM_BUTTON_ID					1

#define TIMER_ID_PROCESS_MANAGEMENT		1
#define TIMER_ID_TIME_DISPLAY			2
#define TIMER_ID_CHECK_STATUS			3

#define INTERVAL_PROCESS_MANAGEMENT		1000
#define INTERVAL_TIME_DISPLAY			1000
#define INTERVAL_CHECK_STATUS			500


int g_lbcnt = 0;
int g_rbcnt = 0;
int g_timeCnt = 0;

SYSTEMTIME g_passTime;


void passTimeCalc(wchar_t *str__)
{
	int hour = 0;
	int min = 0;
	int sec = 0;

	min = g_timeCnt / 60;
	hour = min / 60;
	sec = g_timeCnt % 60;
	min = min % 60;

	wsprintf(str__, L"%02d:%02d:%02d", hour, min, sec);
}


LRESULT CALLBACK WndProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam)
{
	HDC hdc;
	TCHAR str[MAX_PATH] = { 0, };

    switch (message)
    {
	case WM_TIMER:
		switch (wParam)
		{
		case TIMER_ID_TIME_DISPLAY:
			SYSTEMTIME st;

			g_timeCnt++;

			GetLocalTime(&st);

			hdc = GetDC(hWnd);

			HFONT font, oldfont;
			font = CreateFont(50, 0, 0, 0, 0, 0, 0, 0, HANGEUL_CHARSET, 0, 0, 0, 0, L"맑은 굴림");

			oldfont = (HFONT)SelectObject(hdc, font);

			if (false != g_controlManager->getProcessManagementMode())
			{
				passTimeCalc(str);

				//MessageBox(hWnd, str, str, MB_OK);
				//wsprintf(str, L"TIME");
				TextOut(hdc, 400, 70, str, lstrlenW(str));
				wmemset(str, 0x00, MAX_PATH);
			}

			wsprintf(str, L"%02d:%02d:%02d", st.wHour, st.wMinute, st.wSecond);

			
			TextOut(hdc, 400, 10, str, lstrlenW(str));

			SelectObject(hdc, oldfont);

			ReleaseDC(hWnd, hdc);

			DeleteObject(font);
			break;

		case TIMER_ID_CHECK_STATUS:
			// 프로그램 종료 상태 여부 확인
			if (false != g_controlManager->getProcessTerminateMode())
			{
				SetWindowTextW(hWnd, L"프로그램 종료가 가능합니다... ★★★★★");
				break;
			}
			// 시험 시작 전이라면 별도 처리 없음
			if (false == g_controlManager->getProcessManagementMode())
				break;

			// 비밀번호 입력 모드 확인 및 처리
			if (false == g_controlManager->pwdController.getInputMode())
				SetWindowTextW(hWnd, L"시험을 시작하였습니다...");
			else
				SetWindowTextW(hWnd, L"시험을 시작하였습니다..");

			break;

		default:
			break;
		}
		break;

	case WM_CREATE:
		// 시험 시작 버튼 생성
		g_controlManager->examControlButton = CreateWindow(
			L"button", L"시험 시작",
			WS_CHILD | WS_VISIBLE | BS_PUSHBUTTON,
			20,
			80,
			150,
			50,
			hWnd,
			(HMENU)EXAM_BUTTON_ID,
			hInst,
			NULL);

		SetWindowTextW(hWnd, L"시험 시작 전입니다...");

		SetTimer(hWnd, TIMER_ID_PROCESS_MANAGEMENT, INTERVAL_PROCESS_MANAGEMENT, (TIMERPROC)&(g_processManager->checkProcessMain));
		SetTimer(hWnd, TIMER_ID_TIME_DISPLAY, INTERVAL_TIME_DISPLAY, NULL);
		SetTimer(hWnd, TIMER_ID_CHECK_STATUS, INTERVAL_CHECK_STATUS, NULL);
		SendMessage(hWnd, WM_TIMER, TIMER_ID_PROCESS_MANAGEMENT, NULL);

		//SetWindowPos(hWnd, HWND_TOP, 500, 50, 850, 200, SWP_NOSIZE);
		break;

	case WM_KEYDOWN:
		switch (wParam)
		{
		case VK_ESCAPE:
			if (false != g_controlManager->pwdController.requestRelease())
			{
				break;
			}
			break;

		case VK_BACK:
			g_controlManager->pwdController.requestBackSpace();
			break;

		default:
			g_controlManager->pwdController.enterPassword(wParam);
			break;
		}

		if (false != g_controlManager->pwdController.getStatus())
		{
			MessageBox(hWnd, L"입력 완료", L"수고하셨습니다.", MB_OK);
			g_controlManager->setProcessTerminateMode();
		}

		break;

	case WM_MOUSEMOVE:
		g_lbcnt = 0;
		g_rbcnt = 0;
		break;

	case WM_LBUTTONDOWN:
		g_lbcnt++;

		if (1 == g_rbcnt)
		{
			/// 프로세스를 종료 가능 상태로 변경
			g_controlManager->setProcessTerminateMode();
		}
		break;

	case WM_RBUTTONDOWN:
		if (3 != g_lbcnt)
			break;

		g_rbcnt++;
		break;

    case WM_COMMAND:
        {
            int wmId = LOWORD(wParam);
            // 메뉴 선택을 구문 분석합니다:
            switch (wmId)
            {
            case IDM_ABOUT:
                DialogBox(hInst, MAKEINTRESOURCE(IDD_ABOUTBOX), hWnd, About);
                break;
            case IDM_EXIT:
                DestroyWindow(hWnd);
                break;
			case EXAM_BUTTON_ID:
				/// 시험 시작으로 프로세스 제어 시작
				g_controlManager->setProcessManagementMode();
				ShowWindow(g_controlManager->examControlButton, SW_HIDE);
				SetWindowTextW(hWnd, L"시험을 시작하였습니다...");
				GetLocalTime(&g_passTime);
				break;
            default:
                return DefWindowProc(hWnd, message, wParam, lParam);
            }
        }
        break;
    case WM_PAINT:
        {
            PAINTSTRUCT ps;
            HDC hdc = BeginPaint(hWnd, &ps);
            // TODO: 여기에 hdc를 사용하는 그리기 코드를 추가합니다...
			
			wsprintf(str, L"공부하신만큼 좋은 성적 거두길 바라겠습니다.  :D");
			TextOut(hdc, 10, 10, str, lstrlenW(str));
			wmemset(str, 0x00, MAX_PATH);
			wsprintf(str, L"본 프로그램을 죽이지 마세요 ^^;");
			TextOut(hdc, 10, 30, str, lstrlenW(str));
			wmemset(str, 0x00, MAX_PATH);
			
			wsprintf(str, L"죽이기를 시도하면, 벌칙이 주어질 수 있습니다.");
			TextOut(hdc, 10, 50, str, lstrlenW(str));
			wmemset(str, 0x00, MAX_PATH);

			if (0 != g_controlManager->getExecuteStatus())
			{
				HPEN myPen, oldPen;

				myPen = CreatePen(PS_SOLID, 1, RGB(255, 0, 0));
				oldPen = (HPEN)SelectObject(hdc, myPen);

				wsprintf(str, L"더 이상 시도하지 마세요!");
				TextOut(hdc, 415, 10, str, lstrlenW(str));

				SelectObject(hdc, oldPen);
				DeleteObject(myPen);
			}

            EndPaint(hWnd, &ps);
        }
        break;

	case WM_CLOSE:
		if (false == g_controlManager->getProcessTerminateMode())
		{
			MessageBox(hWnd, L"종료 버튼을 누르지 마세요!!! 막혀있습니다!!!", L"!!경고!!", MB_OK);
		}
		else
		{
			PostQuitMessage(0);
		}
		break;

    case WM_DESTROY:
		STARTUPINFO SI;
		PROCESS_INFORMATION PI;
		TCHAR procName[MAX_PATH];
		
		wmemset(procName, 0x00, MAX_PATH);
		memset(&SI, 0x00, sizeof(SI));

		if (false == g_controlManager->getProcessTerminateMode())
		{
			if (false == g_controlManager->genExecuteProcessString(procName, MAX_PATH))
				return -1;

			CreateProcess(NULL, procName, NULL, NULL, NULL, 0, NULL, NULL, &SI, &PI);
		}
        PostQuitMessage(0);
        break;
    default:
        return DefWindowProc(hWnd, message, wParam, lParam);
    }
    return 0;
}

// 정보 대화 상자의 메시지 처리기입니다.
INT_PTR CALLBACK About(HWND hDlg, UINT message, WPARAM wParam, LPARAM lParam)
{
    UNREFERENCED_PARAMETER(lParam);
    switch (message)
    {
    case WM_INITDIALOG:
        return (INT_PTR)TRUE;

    case WM_COMMAND:
        if (LOWORD(wParam) == IDOK || LOWORD(wParam) == IDCANCEL)
        {
            EndDialog(hDlg, LOWORD(wParam));
            return (INT_PTR)TRUE;
        }
        break;
    }
    return (INT_PTR)FALSE;
}
