#include<jni.h>
#include<stdlib.h>

// variables that both C and C++ code have access to
const char *win = "no";
const char *cords;
const char *game;
#define COLSIZE 6
#define ROWSIZE 7

bool wincheck(int xmove, int ymove, int player);
bool horizontalwin(int xmove, int ymove, int player);
bool verticalwin(int xmove, int ymove, int player);
bool diagwin(int xmove, int ymove, int player);
bool negdiagwin(int xmove, int ymove, int player);

int gameboard[7][6];

int x, y,xmove,ymove;
int player;

int count=0;//starts with player one (modulus returns 0 for player1, 1 for player2)

/*
 *Include the following files as public native ints in main java file
 *
	//game functions
	public native String getWin();
	public native String setUserInput(String juserInput);
 *
 */

//prototypes giving public access to CPP functions called by C code

 //void cppsetUserInput();
 char *cppGetWin();

//wrapped C code for link between C++ and JNI

extern "C"
{
	jstring
	Java_com_example_Connect4_Board_getWin(JNIEnv *env,  jobject obj)
	{
		return env->NewStringUTF(cppGetWin());
	}

	jstring
	Java_com_example_Connect4_Board_setUserInput(JNIEnv *env,  jobject obj, jstring juserInput)
	{
		cords=env->GetStringUTFChars(juserInput, NULL);
		env->ReleaseStringUTFChars(juserInput,cords);
		return env->NewStringUTF("I don't care");
	}
	jstring
	Java_com_example_Connect4_Board_setGameBoard(JNIEnv *env,  jobject obj, jstring jboard)
		{
			game=env->GetStringUTFChars(jboard, NULL);
			env->ReleaseStringUTFChars(jboard,game);
			return env->NewStringUTF("I don't care");
		}

}

char *cppGetWin()
{
	for(int i=1; i<8;i++)
	{
		for(int j=0;j<6;j++)
		{
			gameboard[i-1][j]=(int)cords[(i-1)*j];
		}
	}


	player = count%2; //takes the count and determines the player from it (even vs. odd)
	int num= (int)cords;
	 x = (int)num-10;
	 y = (int)(((num-10)-x)*10);
	 xmove = x;
	 ymove = y;
	gameboard[x][y]=player; //passes either a 0 or 1 where the player made a move
	count += 1; //increases the count to effectively change the player the next time this function gets called

	bool check = wincheck(xmove,ymove,player);
	horizontalwin(xmove,ymove,player);
	verticalwin(xmove,ymove,player);
	diagwin(xmove,ymove,player);
	negdiagwin(xmove, ymove,player);
	if(check)
		return "win";
	else
		return "no";

}





bool wincheck(int xmove, int ymove, int player){
    if (horizontalwin(xmove, ymove, player)){
        return true;
    }
    else if (verticalwin(xmove, ymove, player)){
        return true;
    }
    else if(diagwin(xmove, ymove, player)){
        return true;
    }
    else if(negdiagwin(xmove, ymove, player)){
        return true;
    }
    else{
        return false;
    }
}

bool horizontalwin(int xmove, int ymove, int player){ //checks for a horizontal win

    int count=0;
    int score=0;

    while ((xmove+count)>=0 && (xmove+count<=COLSIZE)){
        if (gameboard[ymove][xmove+count]==player){ //add 1 to the score for every same token to the right
            score++;
            count++;
        }
        else{
            break; //break out of the loop if the combo ends
        }
    }

    count=1;

    while ((xmove-count)>=0 && (xmove-count<=COLSIZE)){
        if (gameboard[ymove][xmove-count]==player){ //add 1 to the score for every same token to the left
            score++;
            count++;
        }
        else{
            break; //break out of the loop if the combo ends
        }
    }

    if(score==4){
        return true;
    }
    else{
        return false;
    }


}

bool verticalwin(int xmove, int ymove, int player){ //checks for vertical wins
    int score=0;
    int count=0;

    while((ymove+count>=0) && (ymove+count<=ROWSIZE)){ //we only need to check below the ymove, because above it, there is nothing
        if (gameboard[ymove+count][xmove]==player){
            count++;
            score++;
        }
        else{
            break;
        }
    }


    if(score==4){
        return true;
    }
    else{
        return false;
    }

}

bool diagwin(int xmove, int ymove, int player){
    int count=0;
    int score=0;

    while ((xmove+count)>=0 && (xmove+count<=COLSIZE) &&(ymove+count>=0) && (ymove+count<=ROWSIZE)){
        if (gameboard[ymove+count][xmove+count]==player){ //add 1 to the score for every same token to the bottom right
            score++;
            count++;
        }
        else{
            break; //break out of the loop if the combo ends
        }
    }

    count=1;

    while ((xmove-count)>=0 && (xmove-count<=COLSIZE)&&(ymove-count>=0) && (ymove-count<=ROWSIZE)){
        if (gameboard[ymove-count][xmove-count]==player){ //add 1 to the score for every same token to the top left
            score++;
            count++;
        }
        else{
            break; //break out of the loop if the combo ends
        }
    }

    if(score==4){
        return true;
    }
    else{
        return false;
    }
}

bool negdiagwin(int xmove, int ymove, int player){
    int count=0;
    int score=0;

    while ((xmove+count)>=0 && (xmove+count<=COLSIZE) &&(ymove-count>=0) && (ymove-count<=ROWSIZE)){
        if (gameboard[ymove-count][xmove+count]==player){ //add 1 to the score for every same token to the top right
            score++;
            count++;
        }
        else{
            break; //break out of the loop if the combo ends
        }
    }


    count=1;

    while ((xmove-count)>=0 && (xmove-count<=COLSIZE)&&(ymove+count>=0) && (ymove+count<=ROWSIZE)){
        if (gameboard[ymove+count][xmove-count]==player){ //add 1 to the score for every same token to the bottom left
            score++;
            count++;
        }
        else{
            break; //break out of the loop if the combo ends
        }
    }

    if(score==4){
        return true;
    }
    else{
        return false;
    }
}

