/*******************************************************************
 * \file	algorithm.h
 * \brief	게임의 주요 알고리즘들을 구현
 * \author	wikim
 * \date	2021.05.17.
 *********************************************************************/

#pragma once
#include <iostream>
#include <stdlib.h>		/// srand( ), rand( ) 함수
#include <time.h>		/// time( ) 함수
#include "utility.h"


/// 가위, 바위, 보 상수 선언
#define GAME_SCISSORS		0
#define GAME_ROCK			1
#define GAME_PAPER			2

/// 가위, 바위, 보 문자열 선언
#define GAME_STR_SCISSORS	"가위"
#define GAME_STR_ROCK		"바위"
#define GAME_STR_PAPER		"보"

/// 게임 승패 결과 상수 성언
#define GAME_DRAW			0
#define GAME_USER_WIN		1
#define GAME_USER_LOSE		2

/// 게임 결과
#define STR_DRAW			"비김"
#define STR_USER_WIN		"이김"
#define STR_USER_LOSE		"짐"
#define STR_ERROR			"오류"

/// 게임 결과 저장 배열
const static int gameMetrix[ 3 ][ 3 ] = {
	/// 컴퓨터가 가위인 경우의 승패
	{ GAME_DRAW, GAME_USER_WIN, GAME_USER_LOSE },
	/// 컴퓨터가 바위인 경우의 승패
	{ GAME_USER_LOSE, GAME_DRAW, GAME_USER_WIN },
	/// 컴퓨터가 보인 경우의 승패
	{ GAME_USER_WIN, GAME_USER_LOSE, GAME_DRAW }
};

/**
 * @brief	공정한 게임
 */
int NormalGame( );

/**
 * @brief	컴퓨터가 항상 이기는 게임
 */
int ComputerWinGame(int user__);

/**
 * @brief	항상 사용자가 이기는 게임
 */
int UserWinGame(int user__);

/**
 * @brief	항상 비기는 게임
 */
int DrawGame(int user__);
