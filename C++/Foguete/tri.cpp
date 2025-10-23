#include <GL/glut.h>
    #include <GL/gl.h>
    #include <GL/glu.h>

#include <stdlib.h>
#include <cstdlib>

void tria(){
	
	
	glBegin(GL_TRIANGLES);
	glColor3f(1,0,0);
	
	glVertex2f(0,0);
	glVertex2f(25,50);
	glVertex2f(50,0);
	glEnd();
	
}