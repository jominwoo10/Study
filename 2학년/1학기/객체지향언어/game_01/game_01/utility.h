/*******************************************************************
 * \file	utility.h
 * \brief	게임 동작을 위한 유틸리티 기능 구현
 * \author	wikim
 * \date	2021.05.17.
 *********************************************************************/

#pragma once
#include <iostream>

/**
 * @brief	랜덤 값(0, 1, 2)을 생성하여 반환
 * 
 * @return	컴퓨터의 가위(0), 바위(1), 보(2) 중의 하나 값
 */
int RamdomValue( );


/**
 * @brief	가위, 바위, 보를 문자열로 반환
 */
const char* getGameString(int value);


/**
 * @brief	게임 결과를 문자열로 반환
 */
const char* getGameResultString(int result);
