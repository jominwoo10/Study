#include "utility.h"

#include "algorithm.h"


int RamdomValue()
{
	int value = 0;

	/// 0, 1, 2�� ���� �� ����
	value = rand() % 3;

	return value;
}


const char* getGameString(int value__)
{
	switch (value__)
	{
		/// ���� ���ڿ� ��ȯ
		case GAME_SCISSORS:
			return GAME_STR_SCISSORS;

		/// ���� ���ڿ� ��ȯ
		case GAME_ROCK:
			return GAME_STR_ROCK;

		/// �� ���ڿ� ��ȯ
		case GAME_PAPER:
			return GAME_STR_PAPER;

		default:
			break;
	}

	/// ���� ���ڿ� ��ȯ
	return STR_ERROR;
}


const char* getGameResultString(int result)
{
	switch (result)
	{
		/// ��� ���ڿ� ��ȯ
		case GAME_DRAW:
			return STR_DRAW;

		/// �̱� ���ڿ� ��ȯ
		case GAME_USER_WIN:
			return STR_USER_WIN;

		/// �� ���ڿ� ��ȯ
		case GAME_USER_LOSE:
			return STR_USER_LOSE;

		default:
			break;
	}

	/// ���� ���ڿ� ��ȯ
	return STR_ERROR;
}
