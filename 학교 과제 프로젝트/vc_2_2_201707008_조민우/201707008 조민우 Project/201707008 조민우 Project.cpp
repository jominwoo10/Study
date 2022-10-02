// 201707008 조민우 Project.cpp : 애플리케이션에 대한 진입점을 정의합니다.
//

#include "framework.h"
#include "201707008 조민우 Project.h"

#include <stdlib.h>  // 랜덤(무작위) 관련 함수
#include <time.h>    // SEED 변경. 현재 시간 값이 SEED로 사용되면 항상 다른 값.

#define MAX_LOADSTRING 100

// 전역 변수:
HINSTANCE hInst;                                // 현재 인스턴스입니다.
WCHAR szTitle[MAX_LOADSTRING];                  // 제목 표시줄 텍스트입니다.
WCHAR szWindowClass[MAX_LOADSTRING];            // 기본 창 클래스 이름입니다.

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

	// TODO: 여기에 코드를 입력합니다.

	// 전역 문자열을 초기화합니다.
	LoadStringW(hInstance, IDS_APP_TITLE, szTitle, MAX_LOADSTRING);
	LoadStringW(hInstance, IDC_MY201707008PROJECT, szWindowClass, MAX_LOADSTRING);
	MyRegisterClass(hInstance);

	// 애플리케이션 초기화를 수행합니다:
	if (!InitInstance(hInstance, nCmdShow))
	{
		return FALSE;
	}

	HACCEL hAccelTable = LoadAccelerators(hInstance, MAKEINTRESOURCE(IDC_MY201707008PROJECT));

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

	return (int)msg.wParam;
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

	wcex.style = CS_HREDRAW | CS_VREDRAW;
	wcex.lpfnWndProc = WndProc;
	wcex.cbClsExtra = 0;
	wcex.cbWndExtra = 0;
	wcex.hInstance = hInstance;
	wcex.hIcon = LoadIcon(hInstance, MAKEINTRESOURCE(IDI_MY201707008PROJECT));
	wcex.hCursor = LoadCursor(nullptr, IDC_ARROW);
	wcex.hbrBackground = (HBRUSH)(COLOR_WINDOW + 1);
	wcex.lpszMenuName = MAKEINTRESOURCEW(IDC_MY201707008PROJECT);
	wcex.lpszClassName = szWindowClass;
	wcex.hIconSm = LoadIcon(wcex.hInstance, MAKEINTRESOURCE(IDI_SMALL));

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
	RECT Size = { 0,0,1000,600 };	AdjustWindowRect(&Size, WS_OVERLAPPEDWINDOW, FALSE);	HWND hWnd = CreateWindowW(szWindowClass, L"가로 슈팅게임", WS_OVERLAPPEDWINDOW,		CW_USEDEFAULT, CW_USEDEFAULT, Size.right - Size.left, Size.bottom - Size.top, nullptr, nullptr, hInstance, nullptr);

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

//플레이어 변수
RECT play_me;

//몬스터 변수
RECT play_you[5];

//장애물(돌) 변수
RECT play_stone[3];

//총알
RECT play_gun[50];

//겹침영역 확인 변수
RECT hit;

//게임 목숨 초기 5 몫
int game_life;

//게임 점수 변수 누적
int game_combo;

//게임 시간 변수 기본 10초 몬스터 한마리 제거당 +1초 / 장애물 제거당 -1초
int game_time;

//게임 난이도 조절 
int game_level;

//space바가 눌렸는지 확인해주는 변수
int game_g;

//총알 제어를 위한 flag변수
int flag = -1;



//타이머 ID 값을 선언
#define TIMER_ID_1      1       // 상대의 움직임을 위한 주기적인 호출 ID
#define TIMER_ID_2      2       // 제한 시간 타이머
#define ID_button       3

LRESULT CALLBACK WndProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam)
{

	switch (message)
	{
	case WM_COMMAND:
	{
		int wmId = LOWORD(wParam);
		// 메뉴 선택을 구문 분석합니다:
		switch (wmId)
		{
		case ID_button:
			MessageBox(hWnd, L"메시지박스 X표시를 꾹 눌르면서 보세요\n슈팅게임입니다.\n시간은 1분, 총알은 총 50발이니 신중하게 쏘시기 바랍니다.\n빨간네모 -> 몬스터, 갈색네모 -> 장애물\n몬스터를 맞추면 콤보 +1 콤보 5 -> 생명 1획득\n장애물을 맞추면 콤보 0으로 초기화, 생명 - 1 \n몬스터에 맞거나 장애물에 맞으면 생명-1 콤보초기화\n몬스터 맞출시 시간+1초 장애물 맞출시 시간 -1초", L"게임 설명", MB_OK);
			break;
		case IDM_ABOUT:
			DialogBox(hInst, MAKEINTRESOURCE(IDD_ABOUTBOX), hWnd, About);
			break;
		case IDM_EXIT:
			DestroyWindow(hWnd);
			break;
		default:
			return DefWindowProc(hWnd, message, wParam, lParam);
		}
	}
	break;
	// 플레이어 이동

	case WM_KEYDOWN:

		switch (wParam)
		{
			//윗 방향키를 눌렀을시
		case VK_UP:
			if (play_me.top > 30) //실행창 top 제한
			{
				play_me.top -= 10;
				play_me.bottom -= 10;
			}
			break;

			//아랫 방향키를 눌렀을 시
		case VK_DOWN:
			if (play_me.bottom < 580) //실행창 bottom 제한
			{
				play_me.top += 10;
				play_me.bottom += 10;
			}
			break;

			//space바를 눌렀을시
		case VK_SPACE:
			game_g = 1;
			flag++;
			
			if (flag == 0)
			{
				play_gun[0].left = play_me.left;
				play_gun[0].top = play_me.top + 15;
				play_gun[0].right = play_me.right;
				play_gun[0].bottom = play_me.bottom - 10;
			}
			else if (flag == 1)
			{
				play_gun[1].left = play_me.left;
				play_gun[1].top = play_me.top + 15;
				play_gun[1].right = play_me.right;
				play_gun[1].bottom = play_me.bottom - 10;
			}
			else if (flag == 2)
			{
				play_gun[2].left = play_me.left;
				play_gun[2].top = play_me.top + 15;
				play_gun[2].right = play_me.right;
				play_gun[2].bottom = play_me.bottom - 10;
			}
			else if (flag == 3)
			{
				play_gun[3].left = play_me.left;
				play_gun[3].top = play_me.top + 15;
				play_gun[3].right = play_me.right;
				play_gun[3].bottom = play_me.bottom - 10;
			}
			else if (flag == 4)
			{
				play_gun[4].left = play_me.left;
				play_gun[4].top = play_me.top + 15;
				play_gun[4].right = play_me.right;
				play_gun[4].bottom = play_me.bottom - 10;
			}
			else if (flag == 5)
			{
				play_gun[5].left = play_me.left;
				play_gun[5].top = play_me.top + 15;
				play_gun[5].right = play_me.right;
				play_gun[5].bottom = play_me.bottom - 10;
			}
			else if (flag == 6)
			{
				play_gun[6].left = play_me.left;
				play_gun[6].top = play_me.top + 15;
				play_gun[6].right = play_me.right;
				play_gun[6].bottom = play_me.bottom - 10;
			}
			else if (flag == 7)
			{
				play_gun[7].left = play_me.left;
				play_gun[7].top = play_me.top + 15;
				play_gun[7].right = play_me.right;
				play_gun[7].bottom = play_me.bottom - 10;
			}
			else if (flag == 8)
			{
				play_gun[8].left = play_me.left;
				play_gun[8].top = play_me.top + 15;
				play_gun[8].right = play_me.right;
				play_gun[8].bottom = play_me.bottom - 10;
			}
			else if (flag == 9)
			{
				play_gun[9].left = play_me.left;
				play_gun[9].top = play_me.top + 15;
				play_gun[9].right = play_me.right;
				play_gun[9].bottom = play_me.bottom - 10;
			}
			else if (flag == 10)
			{
				play_gun[10].left = play_me.left;
				play_gun[10].top = play_me.top + 15;
				play_gun[10].right = play_me.right;
				play_gun[10].bottom = play_me.bottom - 10;
			}
			else if (flag == 11)
			{
				play_gun[11].left = play_me.left;
				play_gun[11].top = play_me.top + 15;
				play_gun[11].right = play_me.right;
				play_gun[11].bottom = play_me.bottom - 10;
			}
			else if (flag == 12)
			{
				play_gun[12].left = play_me.left;
				play_gun[12].top = play_me.top + 15;
				play_gun[12].right = play_me.right;
				play_gun[12].bottom = play_me.bottom - 10;
			}
			else if (flag == 13)
			{
				play_gun[13].left = play_me.left;
				play_gun[13].top = play_me.top + 15;
				play_gun[13].right = play_me.right;
				play_gun[13].bottom = play_me.bottom - 10;
			}
			else if (flag == 14)
			{
				play_gun[14].left = play_me.left;
				play_gun[14].top = play_me.top + 15;
				play_gun[14].right = play_me.right;
				play_gun[14].bottom = play_me.bottom - 10;
			}
			else if (flag == 15)
			{
				play_gun[15].left = play_me.left;
				play_gun[15].top = play_me.top + 15;
				play_gun[15].right = play_me.right;
				play_gun[15].bottom = play_me.bottom - 10;
			}
			else if (flag == 16)
			{
				play_gun[16].left = play_me.left;
				play_gun[16].top = play_me.top + 15;
				play_gun[16].right = play_me.right;
				play_gun[16].bottom = play_me.bottom - 10;
			}
			else if (flag == 17)
			{
				play_gun[17].left = play_me.left;
				play_gun[17].top = play_me.top + 15;
				play_gun[17].right = play_me.right;
				play_gun[17].bottom = play_me.bottom - 10;
			}
			else if (flag == 18)
			{
				play_gun[18].left = play_me.left;
				play_gun[18].top = play_me.top + 15;
				play_gun[18].right = play_me.right;
				play_gun[18].bottom = play_me.bottom - 10;
			}
			else if (flag == 19)
			{
				play_gun[19].left = play_me.left;
				play_gun[19].top = play_me.top + 15;
				play_gun[19].right = play_me.right;
				play_gun[19].bottom = play_me.bottom - 10;
			}
			else if (flag == 20)
			{
				play_gun[20].left = play_me.left;
				play_gun[20].top = play_me.top + 15;
				play_gun[20].right = play_me.right;
				play_gun[20].bottom = play_me.bottom - 10;
			}
			else if (flag == 21)
			{
				play_gun[21].left = play_me.left;
				play_gun[21].top = play_me.top + 15;
				play_gun[21].right = play_me.right;
				play_gun[21].bottom = play_me.bottom - 10;
			}
			else if (flag == 22)
			{
				play_gun[22].left = play_me.left;
				play_gun[22].top = play_me.top + 15;
				play_gun[22].right = play_me.right;
				play_gun[22].bottom = play_me.bottom - 10;
			}
			else if (flag == 23)
			{
				play_gun[15].left = play_me.left;
				play_gun[15].top = play_me.top + 15;
				play_gun[15].right = play_me.right;
				play_gun[15].bottom = play_me.bottom - 10;
			}
			else if (flag == 24)
			{
				play_gun[24].left = play_me.left;
				play_gun[24].top = play_me.top + 15;
				play_gun[24].right = play_me.right;
				play_gun[24].bottom = play_me.bottom - 10;
			}
			else if (flag == 25)
			{
				play_gun[25].left = play_me.left;
				play_gun[25].top = play_me.top + 15;
				play_gun[25].right = play_me.right;
				play_gun[25].bottom = play_me.bottom - 10;
			}
			else if (flag == 26)
			{
				play_gun[26].left = play_me.left;
				play_gun[26].top = play_me.top + 15;
				play_gun[26].right = play_me.right;
				play_gun[26].bottom = play_me.bottom - 10;
			}
			else if (flag == 27)
			{
				play_gun[27].left = play_me.left;
				play_gun[27].top = play_me.top + 15;
				play_gun[27].right = play_me.right;
				play_gun[27].bottom = play_me.bottom - 10;
			}
			else if (flag == 28)
			{
				play_gun[28].left = play_me.left;
				play_gun[28].top = play_me.top + 15;
				play_gun[28].right = play_me.right;
				play_gun[28].bottom = play_me.bottom - 10;
			}
			else if (flag == 29)
			{
				play_gun[29].left = play_me.left;
				play_gun[29].top = play_me.top + 15;
				play_gun[29].right = play_me.right;
				play_gun[29].bottom = play_me.bottom - 10;
			}
			else if (flag == 30)
			{
				play_gun[30].left = play_me.left;
				play_gun[30].top = play_me.top + 15;
				play_gun[30].right = play_me.right;
				play_gun[30].bottom = play_me.bottom - 10;
			}
			else if (flag == 31)
			{
				play_gun[31].left = play_me.left;
				play_gun[31].top = play_me.top + 15;
				play_gun[31].right = play_me.right;
				play_gun[31].bottom = play_me.bottom - 10;
			}
			else if (flag == 32)
			{
				play_gun[32].left = play_me.left;
				play_gun[32].top = play_me.top + 15;
				play_gun[32].right = play_me.right;
				play_gun[32].bottom = play_me.bottom - 10;
			}
			else if (flag == 33)
			{
				play_gun[33].left = play_me.left;
				play_gun[33].top = play_me.top + 15;
				play_gun[33].right = play_me.right;
				play_gun[33].bottom = play_me.bottom - 10;
			}
			else if (flag == 34)
			{
				play_gun[34].left = play_me.left;
				play_gun[34].top = play_me.top + 15;
				play_gun[34].right = play_me.right;
				play_gun[34].bottom = play_me.bottom - 10;
			}
			else if (flag == 35)
			{
				play_gun[35].left = play_me.left;
				play_gun[35].top = play_me.top + 15;
				play_gun[35].right = play_me.right;
				play_gun[35].bottom = play_me.bottom - 10;
			}
			else if (flag == 36)
			{
				play_gun[36].left = play_me.left;
				play_gun[36].top = play_me.top + 15;
				play_gun[36].right = play_me.right;
				play_gun[36].bottom = play_me.bottom - 10;
			}
			else if (flag == 37)
			{
				play_gun[37].left = play_me.left;
				play_gun[37].top = play_me.top + 15;
				play_gun[37].right = play_me.right;
				play_gun[37].bottom = play_me.bottom - 10;
			}
			else if (flag == 38)
			{
				play_gun[38].left = play_me.left;
				play_gun[38].top = play_me.top + 15;
				play_gun[38].right = play_me.right;
				play_gun[38].bottom = play_me.bottom - 10;
			}
			else if (flag == 39)
			{
				play_gun[39].left = play_me.left;
				play_gun[39].top = play_me.top + 15;
				play_gun[39].right = play_me.right;
				play_gun[39].bottom = play_me.bottom - 10;
			}
			else if (flag == 40)
			{
				play_gun[40].left = play_me.left;
				play_gun[40].top = play_me.top + 15;
				play_gun[40].right = play_me.right;
				play_gun[40].bottom = play_me.bottom - 10;
			}
			else if (flag == 41)
			{
				play_gun[41].left = play_me.left;
				play_gun[41].top = play_me.top + 15;
				play_gun[41].right = play_me.right;
				play_gun[41].bottom = play_me.bottom - 10;
			}
			else if (flag == 42)
			{
				play_gun[42].left = play_me.left;
				play_gun[42].top = play_me.top + 15;
				play_gun[42].right = play_me.right;
				play_gun[42].bottom = play_me.bottom - 10;
			}
			else if (flag == 43)
			{
				play_gun[43].left = play_me.left;
				play_gun[43].top = play_me.top + 15;
				play_gun[43].right = play_me.right;
				play_gun[43].bottom = play_me.bottom - 10;
			}
			else if (flag == 44)
			{
				play_gun[44].left = play_me.left;
				play_gun[44].top = play_me.top + 15;
				play_gun[44].right = play_me.right;
				play_gun[44].bottom = play_me.bottom - 10;
			}
			else if (flag == 45)
			{
				play_gun[45].left = play_me.left;
				play_gun[45].top = play_me.top + 15;
				play_gun[45].right = play_me.right;
				play_gun[45].bottom = play_me.bottom - 10;
			}
			else if (flag == 46)
			{
				play_gun[46].left = play_me.left;
				play_gun[46].top = play_me.top + 15;
				play_gun[46].right = play_me.right;
				play_gun[46].bottom = play_me.bottom - 10;
			}
			else if (flag == 47)
			{
				play_gun[47].left = play_me.left;
				play_gun[47].top = play_me.top + 15;
				play_gun[47].right = play_me.right;
				play_gun[47].bottom = play_me.bottom - 10;
			}
			else if (flag == 48)
			{
				play_gun[48].left = play_me.left;
				play_gun[48].top = play_me.top + 15;
				play_gun[48].right = play_me.right;
				play_gun[48].bottom = play_me.bottom - 10;
			}
			else if (flag == 49)
			{
				play_gun[49].left = play_me.left;
				play_gun[49].top = play_me.top + 15;
				play_gun[49].right = play_me.right;
				play_gun[49].bottom = play_me.bottom - 10;
			}
			break;

		}
		InvalidateRect(hWnd, NULL, TRUE);
		break;

	case WM_CREATE:
	{
		MessageBox(hWnd, L"슈팅게임입니다.\n시간은 1분, 총알은 총 50발이니 신중하게 쏘시기 바랍니다.\n빨간네모 -> 몬스터, 갈색네모 -> 장애물\n몬스터를 맞추면 콤보 +1 콤보 5 -> 생명 1획득\n장애물을 맞추면 콤보 0으로 초기화, 생명 - 1\n몬스터에 맞거나 장애물에 맞으면 생명-1 콤보초기화\n몬스터 맞출시 시간+1초 장애물 맞출시 시간 -1초", L"게임 설명", MB_OK);
		CreateWindow(TEXT("button"), TEXT("게임재설명"), WS_CHILD | WS_VISIBLE | BS_PUSHBUTTON, 800, 10, 100, 30, hWnd, (HMENU)ID_button, hInst, NULL);

		// 무작위 SEED 값을 현재 시간으로 설정
		srand((unsigned int)time(NULL));

		//플레이어 좌표 설정
		play_me.left = 10;
		play_me.top = 50;
		play_me.right = play_me.left + 30;
		play_me.bottom = play_me.top + 30;

		//장애물 좌표 설정
		for (int j = 0; j < 3; j++)
		{
			int k = j * 2;
			play_stone[j].left = 1100;
			play_stone[j].top = rand() % 100 + 50 + (k * 100 - 2);
			play_stone[j].right = play_stone[j].left + 30;
			play_stone[j].bottom = play_stone[j].top + 30;
		}

		//몬스터 좌표 설정
		for (int i = 0; i < 5; i++)		{			play_you[i].left = 900;			play_you[i].top = rand() % 100 + 50 + (i * 100 - 2);			play_you[i].right = play_you[i].left + 20;
			play_you[i].bottom = play_you[i].top + 20;
		}

		//초기 목숨 5몫
		game_life = 5;

		//제한 시간 설정
		game_time = 60; // 초기 설정 1분
		SetTimer(hWnd, TIMER_ID_2, 1000, NULL);

		//몬스터 움직임 속도 설정
		game_level = 200;

		//시작 콤보 설정
		game_combo = 0;

		//최초 타이머 설정
		game_level = 1000;
		SetTimer(hWnd, TIMER_ID_1, game_level, NULL);

	}
	case WM_TIMER:
	{
		int i, j, k, z = 0;

		if (TIMER_ID_2 == wParam)
		{
			game_time--; // 시간 감소

			if (0 == game_time) // 시간이 0초가 되면
			{
				// 게임 끝
				KillTimer(hWnd, TIMER_ID_1);
				KillTimer(hWnd, TIMER_ID_2);
				MessageBox(hWnd, L"타임 오버", L"게임 종료", MB_OK);
				return 0;
			}
			break;
		}


		// 몬스터 이동
		for (i = 0; i < 5; i++)
		{
			play_you[i].left -= 25;
			play_you[i].right -= 25;

			// 플레이어가 몬스터에 맞았을 경우
			if (TRUE == IntersectRect(&hit, &play_me, &play_you[i]))
			{
				//목숨 1개 감소
				game_life--;
				//콤보 초기화
				game_combo = 0;

				//맞은 몬스터는 재생성
				play_you[i].left = 900;				play_you[i].top = rand() % 100 + 50 + (i * 100 - 2);				play_you[i].right = play_you[i].left + 20;
				play_you[i].bottom = play_you[i].top + 20;
			}
			//목숨 0개 게임종료
			if (game_life == 0)
			{
				KillTimer(hWnd, TIMER_ID_1);
				MessageBox(hWnd, L"생명이 없습니다", L"게임 종료", MB_OK);
				return 0;
			}

			//몬스터가 화면 밖으로 나갈경우 재생성
			if (play_you[i].left < 0)
			{
				play_you[i].left = 900;				play_you[i].top = rand() % 100 + 50 + (i * 100 - 2);				play_you[i].right = play_you[i].left + 20;
				play_you[i].bottom = play_you[i].top + 20;
			}

		}

		//장애물 이동
		for (j = 0; j < 3; j++)
		{
			int k = j * 2;
			play_stone[j].left -= 23;
			play_stone[j].right -= 23;
			//플레이어가 장애물에 맞았을 경우
			if (TRUE == IntersectRect(&hit, &play_me, &play_stone[j]))
			{
				//목숨 -1
				game_life--;
				//콤보 초기화
				game_combo = 0;

				play_stone[j].left = 1100;
				play_stone[j].top = rand() % 100 + 50 + (k * 100 - 2);
				play_stone[j].right = play_stone[j].left + 30;
				play_stone[j].bottom = play_stone[j].top + 30;
				if (game_life == 0)
				{
					KillTimer(hWnd, TIMER_ID_1);
					MessageBox(hWnd, L"생명이 없습니다", L"게임 종료", MB_OK);
					return 0;
				}
			}
			//장애물이 화면 밖으로 나갈경우 재 생성
			if (play_stone[j].left < -10)
			{
				play_stone[j].left = 1100;
				play_stone[j].top = rand() % 100 + 50 + (k * 100 - 2);
				play_stone[j].right = play_stone[j].left + 30;
				play_stone[j].bottom = play_stone[j].top + 30;
			}
		}

		//총알 이동
		for (z = 0; z < 50; z++)
		{
			play_gun[z].left += 30;
			play_gun[z].right += 30;

			//총알이 몬스터를 맞췄을 경우
			for (int x = 0; x < 5; x++)
			{
				if (TRUE == IntersectRect(&hit, &play_gun[z], &play_you[x]))
				{
					//콤보와 시간 증가
					game_combo++;
					game_time++;

					//5배수 콤보 달성시 생명 + 1
					if (game_combo == 5)
					{
						game_life++;
					}
					else if (game_combo == 10)
					{
						game_life++;
					}
					else if (game_combo == 15)
					{
						game_life++;
					}
					else if (game_combo == 20)
					{
						game_life++;
					}
					//맞은 몬스터는 재생성
					play_you[x].left = 900;					play_you[x].top = rand() % 100 + 50 + (x * 100 - 2);					play_you[x].right = play_you[x].left + 20;
					play_you[x].bottom = play_you[x].top + 20;

					play_gun[z].left = 2000;
					play_gun[z].top = play_me.top + 15;
					play_gun[z].right = 2000;
					play_gun[z].bottom = play_me.bottom - 10;

				}

			}
			//총알이 장애물을 맞췄을 경우
			for (int q = 0; q < 3; q++)
			{
				if (TRUE == IntersectRect(&hit, &play_gun[z], &play_stone[q]))
				{
					//콤보0으로 초기화 / 시간 감소 / 생명 감소
					game_combo = 0;
					game_time--;
					game_life--;

					//맞은 장애물은 재생성
					play_stone[q].left = 1100;
					play_stone[q].top = rand() % 100 + 50 + (z * 100 - 2);
					play_stone[q].right = play_stone[q].left + 30;
					play_stone[q].bottom = play_stone[q].top + 30;

					play_gun[z].left = 2000;
					play_gun[z].top = play_me.top + 15;
					play_gun[z].right = 2000;
					play_gun[z].bottom = play_me.bottom - 10;
				}
			}
		}
		
		if (100 != game_level)
		{
			game_level -= 100;
			KillTimer(hWnd, TIMER_ID_1);                    // 1번을 정지
			SetTimer(hWnd, TIMER_ID_1, game_level, NULL);   // 1번으로 새로운 타이머 생성
		}
		InvalidateRect(hWnd, NULL, TRUE);
	}
	break;

	case WM_PAINT:
	{

		int i, j, k = 0;
		//남은 총알 계산 변수
		int bullet = 0;
		WCHAR string[64] = { 0, };
		PAINTSTRUCT ps;
		HDC hdc = BeginPaint(hWnd, &ps);
		HPEN Pen, osPen;
		// TODO: 여기에 hdc를 사용하는 그리기 코드를 추가합니다..

		//flag에 처음에 -1이 들어 있으므로 49에서 빼줌
		bullet = 49 - flag;
		//총알이 0발 까진 다 쏜후 -까지 내려가는 것을 방지
		if (bullet < 0)
		{
			bullet = 0;
		}
		//점수 및 시간 출력
		wsprintfW(string, L"콤보 : %d    목숨 : %d    남은 총알 : %d    제한 시간 : %d초", game_combo, game_life, bullet ,game_time);
		TextOut(hdc, 400, 20, string, lstrlenW(string));

		// 펜을 생성
		Pen = CreatePen(PS_SOLID, 2, RGB(0, 0, 0));
		// 펜을 교체하면서 현재 펜을 보관
		osPen = (HPEN)SelectObject(hdc, Pen);
		//플레이어 생성
		Ellipse(hdc, play_me.left, play_me.top, play_me.right, play_me.bottom);
		// 브러시 복원
		SelectObject(hdc, osPen);
		// 브러시 제거
		DeleteObject(Pen);

		//몬스터 생성
		Pen = CreatePen(PS_SOLID, 2, RGB(255, 0, 0));
		osPen = (HPEN)SelectObject(hdc, Pen);
		for (i = 0; i < 5; i++)
		{
			Rectangle(hdc, play_you[i].left, play_you[i].top, play_you[i].right, play_you[i].bottom);
		}
		SelectObject(hdc, osPen);
		DeleteObject(Pen);

		//장애물 생성
		Pen = CreatePen(PS_SOLID, 2, RGB(102, 51, 0));
		osPen = (HPEN)SelectObject(hdc, Pen);
		for (j = 0; j < 3; j++)
		{
			Rectangle(hdc, play_stone[j].left, play_stone[j].top, play_stone[j].right, play_stone[j].bottom);
		}
		SelectObject(hdc, osPen);
		DeleteObject(Pen);

		//총알 생성
		Pen = CreatePen(PS_SOLID, 3, RGB(0, 0, 0));
		osPen = (HPEN)SelectObject(hdc, Pen);
		if (game_g == 1) //space바가 눌렸을 시 
		{
			for (k = 0; k < 50; k++)
			{
				Rectangle(hdc, play_gun[k].left, play_gun[k].top, play_gun[k].right, play_gun[k].bottom);
			}
		}
		SelectObject(hdc, osPen);
		DeleteObject(Pen);

		EndPaint(hWnd, &ps);
	}
	break;
	case WM_DESTROY:
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