#include <GL/glut.h>
    #include <GL/gl.h>
    #include <GL/glu.h>

#include <stdlib.h>
#include <cstdlib>

void tria(float R, float G, float B){
	
	glColor3f(R,G,B);
	glBegin(GL_TRIANGLES);
	
	
	glVertex2f(0,0);
	glVertex2f(25,50);
	glVertex2f(50,0);
	glEnd();
	
}