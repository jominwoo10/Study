#include "utility.h"

#include "algorithm.h"


int RamdomValue()
{
	int value = 0;

	/// 0, 1, 2의 랜덤 값 생성
	value = rand() % 3;

	return value;
}


const char* getGameString(int value__)
{
	switch (value__)
	{
		/// 가위 문자열 반환
		case GAME_SCISSORS:
			return GAME_STR_SCISSORS;

		/// 바위 문자열 반환
		case GAME_ROCK:
			return GAME_STR_ROCK;

		/// 보 문자열 반환
		case GAME_PAPER:
			return GAME_STR_PAPER;

		default:
			break;
	}

	/// 오류 문자열 반환
	return STR_ERROR;
}


const char* getGameResultString(int result)
{
	switch (result)
	{
		/// 비김 문자열 반환
		case GAME_DRAW:
			return STR_DRAW;

		/// 이김 문자열 반환
		case GAME_USER_WIN:
			return STR_USER_WIN;

		/// 짐 문자열 반환
		case GAME_USER_LOSE:
			return STR_USER_LOSE;

		default:
			break;
	}

	/// 오류 문자열 반환
	return STR_ERROR;
}
