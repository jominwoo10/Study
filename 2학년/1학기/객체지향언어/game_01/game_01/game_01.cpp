// game_01.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>

#include "algorithm.h"


/// 게임 동작을 위해 필요한 정보를 구조체로 선언
typedef struct srp_game_information
{
	/// 사용자의 현재 게임 정보
	int					user;
	/// 컴퓨터의 현재 게임 정보
	int					computer;
	/// 게임 결과
	int					result;

	/// 게임 횟수 누적: 0(비김), 1(사용자가 이김), 2(컴퓨터가 이김)
	int					game_cnt[3];

} GAME_INFO, *PGAME_INFO;


int main()
{
	GAME_INFO info = { 0, };

	/// 현재 시간 값으로 랜덤 seed 값 변경
	srand((unsigned int)time(NULL));

	/// 25회 게임을 수행하도록 구성
	for (int i = 0; i < 25; i++)
	{
		/// 사용자의 값 설정
		info.user = RamdomValue();
		/// 컴퓨터의 값을 공정(?)하게 획득
		info.computer = NormalGame();
		/// 항상 컴퓨터가 이기도록 게임 설정
		//info.computer = ComputerWinGame(info.user);
		/// 항상 사용자가 이기도록 게임 설정
		//info.computer = UserWinGame(info.user);
		/// 항상 비기도록 게임 설정
		//info.computer = DrawGame(info.user);

		/// 게임결과 획득
		info.result = gameMetrix[info.computer][info.user];
		printf("%s [ 사용자: %s ][ 컴퓨터: %s ]\n\n", getGameResultString(info.result), getGameString(info.user), getGameString(info.computer));
		info.game_cnt[info.result]++;
	}

	printf("Total User Win[ %d ] Computer Win[ %d ] Draw[ %d ]", info.game_cnt[GAME_USER_WIN], info.game_cnt[GAME_USER_LOSE], info.game_cnt[GAME_DRAW]);
	return 0;
}
