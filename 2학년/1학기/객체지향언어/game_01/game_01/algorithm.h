/*******************************************************************
 * \file	algorithm.h
 * \brief	������ �ֿ� �˰������ ����
 * \author	wikim
 * \date	2021.05.17.
 *********************************************************************/

#pragma once
#include <iostream>
#include <stdlib.h>		/// srand( ), rand( ) �Լ�
#include <time.h>		/// time( ) �Լ�
#include "utility.h"


/// ����, ����, �� ��� ����
#define GAME_SCISSORS		0
#define GAME_ROCK			1
#define GAME_PAPER			2

/// ����, ����, �� ���ڿ� ����
#define GAME_STR_SCISSORS	"����"
#define GAME_STR_ROCK		"����"
#define GAME_STR_PAPER		"��"

/// ���� ���� ��� ��� ����
#define GAME_DRAW			0
#define GAME_USER_WIN		1
#define GAME_USER_LOSE		2

/// ���� ���
#define STR_DRAW			"���"
#define STR_USER_WIN		"�̱�"
#define STR_USER_LOSE		"��"
#define STR_ERROR			"����"

/// ���� ��� ���� �迭
const static int gameMetrix[ 3 ][ 3 ] = {
	/// ��ǻ�Ͱ� ������ ����� ����
	{ GAME_DRAW, GAME_USER_WIN, GAME_USER_LOSE },
	/// ��ǻ�Ͱ� ������ ����� ����
	{ GAME_USER_LOSE, GAME_DRAW, GAME_USER_WIN },
	/// ��ǻ�Ͱ� ���� ����� ����
	{ GAME_USER_WIN, GAME_USER_LOSE, GAME_DRAW }
};

/**
 * @brief	������ ����
 */
int NormalGame( );

/**
 * @brief	��ǻ�Ͱ� �׻� �̱�� ����
 */
int ComputerWinGame(int user__);

/**
 * @brief	�׻� ����ڰ� �̱�� ����
 */
int UserWinGame(int user__);

/**
 * @brief	�׻� ���� ����
 */
int DrawGame(int user__);
