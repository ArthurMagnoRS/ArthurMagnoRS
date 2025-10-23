#ifdef __APPLE__ // MacOS
    #define GL_SILENCE_DEPRECATION
    #include <GLUT/glut.h>
    #include <OpenGL/gl.h>
    #include <OpenGL/glu.h>
#else // Windows e Linux
    #include <GL/glut.h>
    #include <GL/gl.h>
    #include <GL/glu.h>
#endif
#include <iostream>
#include <stdlib.h>
#include <cstdlib>
#include "triangulo.h"
#include "Circulos.h"
#define ESC 27

// variaveis globais para cores
float R, G, B;

// funcao principal, que vai conter os recursos da janela do objeto

void init(void);
void display(void);
void reshape(int w, int h);
void keyboardExit(unsigned char key, int x, int y);


int main (int argc, char** argv){
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(800,600);
	glutInitWindowPosition(100,100);
	glutCreateWindow("Foguete!");
	init();
	glutReshapeFunc(reshape);
	glutDisplayFunc(display);
	glutKeyboardFunc(keyboardExit);
	glutMainLoop();
	return EXIT_SUCCESS;
	
}

void init (void){
	glClearColor(0.106,0.2,0.309, 1.0); // glClearColor para limpar as cores da tela para branco e inicializar o RGB embaixo
	R = 0.0;
	G = 0.0;
	B = 0.0;
	
}
void keyboardExit(unsigned char key, int x, int y){
	switch (key){
		case ESC: exit(EXIT_SUCCESS); break;
	}
	
}
void reshape (int w, int h){
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	
	glViewport(0, 0, w, h);
	
	glOrtho(0, 800, 0, 600, 1, -1);
	
	glMatrixMode(GL_MODELVIEW);
}





void display (void){
	glClear(GL_COLOR_BUFFER_BIT); // limpa o buffer das cores
	glLoadIdentity(); // carrega a matriz identidade, precisa antes das primitivas
	
	glTranslatef(100,250,0);
	glScalef(0.7,0.7,0);
	glEnd();
	
	//estrelas!!
	glPushMatrix();
	glTranslatef(-20,380,0);
	glScalef(1.5,1.5,0);
	tria(1,1,0);
	glPopMatrix();
	
	glPushMatrix();
	glScalef(1.5,1.5,0);
    glRotatef(180,0,0,1);
	glTranslatef(-37,-286,0);

	tria(1,1,0);
	glPopMatrix();
	////////
	glPushMatrix();
	glTranslatef(380,-150,0);
	

	tria(1,1,0);
	glPopMatrix();
	
	glPushMatrix();

    glRotatef(180,0,0,1);
	glTranslatef(-430,120,0);

	tria(1,1,0);
	glPopMatrix();
	/////////////////
    glPushMatrix();
	
	glTranslatef(650,0,0);
	
	tria(1,1,0);
	
	glPopMatrix();
	
	glPushMatrix();
	
	glTranslatef(700,15,0);
	glRotatef(180,0,0,1);
    glTranslatef(0,-15,0);
	

	tria(1,1,0);
	glPopMatrix();
	////////////
	glPushMatrix();
	glTranslatef(500,250,0);
	tria(1,1,0);
	
	glPopMatrix();
	
	glPushMatrix();
	
	glTranslatef(550,265,0);
	glRotatef(180,0,0,1);
    glTranslatef(0,-15,0);
	
	
	tria(1,1,0);
	glPopMatrix();
	///////////////
	
	glPushMatrix();
	glTranslatef(500,250,0);
	tria(1,1,0);
	
	glPopMatrix();
	
	glPushMatrix();
	
	glTranslatef(550,265,0);
	glRotatef(180,0,0,1);
    glTranslatef(0,-15,0);
	
	
	tria(1,1,0);
	glPopMatrix();
	//////////////////
	glPushMatrix();
	glTranslatef(800,-250,0);
	glScalef(1.5,1.5,0);
	tria(1,1,0);
	
	glPopMatrix();
	
	glPushMatrix();
	glScalef(1.5,1.5,0);
	glTranslatef(585,-150,0);
	glRotatef(180,0,0,1);
    glTranslatef(0,-15,0);
	
	
	tria(1,1,0);
	glPopMatrix();
	///////////////////////////////
	// Lua!!
	
	glPushMatrix();
		glColor3f(0.870, 0.851, 0.765);
		glTranslatef(800,350,0);
		glScalef(11,11,0);
		desenhaCirculo(10,20,true);
		glPopMatrix();
    glPushMatrix();
    	glColor3f(0.772, 0.741, 0.59);
    	glTranslatef(750,380,0);
		glScalef(3,3,0);
		desenhaCirculo(10,20,true);
		glPopMatrix();
	glPushMatrix();
		glColor3f(0.772, 0.741, 0.59);
    	glTranslatef(800,300,0);
		glScalef(3,3,0);
		desenhaCirculo(10,20,true);
		glPopMatrix();
	
	glPushMatrix();
		glColor3f(0.772, 0.741, 0.59);
    	glTranslatef(850,390,0);
		glScalef(3,3,0);
		desenhaCirculo(10,20,true);
		glPopMatrix();
///////////////////////
///////// Foguetão..	
	
	glPushMatrix(); // Corpo
		glColor3f(0.749, 0.749, 0.749);
		
		
		glRotatef(40,0,0,1);
     	glTranslatef(0,-200,0);
		glScalef(12,7,0);
		
		glBegin(GL_POLYGON);
		glVertex2f(0,0);
		glVertex2f(25,0);
		glVertex2f(25,25);
		glVertex2f(0,25);
		glEnd();
	glPopMatrix();
	
	///// marcas vermelha e azul
	glPushMatrix();
	
		glColor3f(0.3098, 0.5059, 0.7373);
		
		glRotatef(40,0,0,1);
     	glTranslatef(0,-200,0);
		glScalef(1,7,0);
		
		glBegin(GL_POLYGON);
		glVertex2f(0,0);
		glVertex2f(25,0);
		glVertex2f(25,25);
		glVertex2f(0,25);
		glEnd();
		glPopMatrix();
		
		// fogo laranja
		
		glPushMatrix();
		  	  
		  	  glTranslatef(-18.8,-185,0);
		  	  glScalef(3,3,0);
		  	  glRotatef(13.5,0,0,1);
		  	  
		  	   tria(1.0, 0.557, 0.004);	
		
			glPopMatrix();
		
		
		//// fogo amarelo
		glPushMatrix();
		  	  
		  	  glTranslatef(10.8,-150.7,0);
		  	  glScalef(2,2,0); // escala vindo depois de translação funciona normalmente, mas o contrário não
		  	  glRotatef(13.5,0,0,1);
		  	  
		  	   tria(1,1,0);	
		
			glPopMatrix();
		/////
		glPushMatrix();
	
		glColor3f(1,0,0);
		
		glRotatef(40,0,0,1);
     	glTranslatef(-50,-125,0);
		glScalef(5.5,1,0);
		
		glBegin(GL_POLYGON);
		glVertex2f(0,0);
		glVertex2f(25,0);
		glVertex2f(25,25);
		glVertex2f(0,25);
		glEnd();
		glPopMatrix();
		
		///// janela
	glPushMatrix();
		glColor3f(0.106, 0.2, 0.309);
			glTranslatef(225,43,0);
			glScalef(7,7,0);
			desenhaCirculo(10,40,true);
		glPopMatrix();
		
    glPushMatrix();
			glColor3f(0.3098, 0.5059, 0.7373);
		glTranslatef(225,43,0);
		glScalef(6,6,0);
		desenhaCirculo(10,40,true);
			glPopMatrix();
     ///// ponta   
	glPushMatrix();
		glRotatef(66.5,0,0,1);
		glTranslatef(180,-308,0);
		glScalef(3,3,0);
		tria(1,0,0);
		glPopMatrix();

	/// "asas", respectivamente direita e esquerda
	glPushMatrix();
		glColor3f(1,0,0);
		glTranslatef(20,-16,0);
		glRotatef(103,0,0,1);
		glScalef (4,4,0);
		
		glBegin(GL_POLYGON);
		glVertex2f(0,0);
		glVertex2f(12.5,-25);
		glVertex2f(25,0);
		glVertex2f(12.5,25);
		glEnd();
		
		glPopMatrix();
		
		
		glPushMatrix();
		glColor3f(1,0,0);
		glTranslatef(223,-190,0);
		glRotatef(156.2,0,0,1);
		glScalef (4,4,0);
		
		glBegin(GL_POLYGON);
		glVertex2f(0,0);
		glVertex2f(12.5,-25);
		glVertex2f(25,0);
		glVertex2f(12.5,25);
		glEnd();
		
		glPopMatrix();
	
	
		  
	glFlush();
	
	
}