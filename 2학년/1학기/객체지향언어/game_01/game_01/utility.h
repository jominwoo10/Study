/*******************************************************************
 * \file	utility.h
 * \brief	���� ������ ���� ��ƿ��Ƽ ��� ����
 * \author	wikim
 * \date	2021.05.17.
 *********************************************************************/

#pragma once
#include <iostream>

/**
 * @brief	���� ��(0, 1, 2)�� �����Ͽ� ��ȯ
 * 
 * @return	��ǻ���� ����(0), ����(1), ��(2) ���� �ϳ� ��
 */
int RamdomValue( );


/**
 * @brief	����, ����, ���� ���ڿ��� ��ȯ
 */
const char* getGameString(int value);


/**
 * @brief	���� ����� ���ڿ��� ��ȯ
 */
const char* getGameResultString(int result);
