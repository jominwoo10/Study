#include "algorithm.h"

#include <iostream>


int NormalGame(	)
{
	return RamdomValue();
}


int ComputerWinGame(int user__)
{
	int i = 0;

	for (; i < 3; i++)
	{
		if (GAME_USER_LOSE == gameMetrix[i][user__])
			break;
	}

	return i;
}


int UserWinGame(int user__)
{
	int i = 0;

	for (; i < 3; i++)
	{
		if (GAME_USER_WIN == gameMetrix[i][user__])
			break;
	}

	return i;
}


int DrawGame(int user__)
{
	int i = 0;

	for (; i < 3; i++)
	{
		if (GAME_DRAW == gameMetrix[i][user__])
			break;
	}

	return i;
}
