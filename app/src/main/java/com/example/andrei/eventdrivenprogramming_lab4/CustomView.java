package com.example.andrei.eventdrivenprogramming_lab4;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.location.Location;
import android.support.v4.util.Pair;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by andrei on 4/20/17.
 */

public class CustomView extends View implements Runnable{
    final int CIRCLE=1;
    final int SQUARE=2;
    static int shape1=1, shape2=1, shape3=1;
    Paint pen;
    public static ArrayList<Ball> ballsList=new ArrayList<>();
    //public static ArrayList<Pair<Float,Float>> newCircles=new ArrayList<>();
    public static ArrayList<Ball> newBallsList=new ArrayList<>();
    private int[] colors=new int[]{Color.GREEN,Color.BLUE,Color.RED,Color.MAGENTA,Color.CYAN,Color.BLACK,Color.DKGRAY,Color.GRAY,Color.YELLOW, Color.LTGRAY};
    int screenWidth;
    int screenHeight;
    int radius=100;
    float x1,x2,y1,y2,x3,y3;


    public void fillPositionsList(){
        ballsList.add(new Ball(new Coordinates(100,150),1,10,Color.RED));
        ballsList.add(new Ball(new Coordinates(300,1500),1,5,Color.BLUE));
        ballsList.add(new Ball(new Coordinates(400,300),4,1,Color.BLACK));
    }

    public CustomView(Context context, AttributeSet attrs){
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setup();
    }


    public void setup(){
        fillPositionsList();
        screenWidth=getScreenWidth();
        screenHeight=getScreenHeight();
        pen=new Paint();
        pen.setColor(Color.RED);
        pen.setAntiAlias(true);
        pen.setStrokeWidth(10);
        pen.setStyle(Paint.Style.STROKE);
        pen.setStrokeJoin(Paint.Join.MITER);
        pen.setStrokeCap(Paint.Cap.SQUARE);

    }


    @Override
    protected void onDraw(Canvas canvas) {

        double distance_1_2,distance_2_3,distance_1_3;

                Ball ball1=ballsList.get(0);
                Ball ball2=ballsList.get(1);
                Ball ball3=ballsList.get(2);

                Square square1=null;
                Square square2=null;
                Square square3=null;


                /* Ball 1 */
                if(shape1==CIRCLE){
                    pen.setColor(ball1.getColor());
                    pen.setStrokeWidth(5);
                    pen.setStyle(Paint.Style.FILL);
                    int posX=ball1.getCoordinates().getxAxisPosition();
                    int posY=ball1.getCoordinates().getyAxisPosition();
                    canvas.drawCircle(posX,posY,radius, pen);
                    checkBounds(ball1);
                    posX=ball1.getCoordinates().getxAxisPosition();
                    posY=ball1.getCoordinates().getyAxisPosition();
                    checkForInversion(posX,posY,ball1);
                    checkForTouchingTopBottomBounds(posY,ball1);

                    if(ball1.getCoordinates().getxAxisPosition()<=radius || ball1.getCoordinates().getxAxisPosition()>=screenWidth-radius){
                        shape1=SQUARE;
                        pen.setColor(ball1.getColor());
                        pen.setStrokeWidth(5);
                        pen.setStyle(Paint.Style.FILL);
                        int lastPosX=ball1.getCoordinates().getxAxisPosition();
                        int lastPosY=ball1.getCoordinates().getyAxisPosition();
                        canvas.drawRect(lastPosX-radius,lastPosY-radius,lastPosX+radius,lastPosY+radius,pen);
                        square1=new Square(lastPosX-radius,lastPosY-radius,lastPosX+radius,lastPosY+radius);
                        invalidate();
                        pen.reset();
                    }
                    invalidate();
                    pen.reset();
                }




                /* Ball 2 */
                if(shape2==CIRCLE){
                    pen.setColor(ball2.getColor());
                    pen.setStrokeWidth(5);
                    pen.setStyle(Paint.Style.FILL);
                    int posX2=ball2.getCoordinates().getxAxisPosition();
                    int posY2=ball2.getCoordinates().getyAxisPosition();
                    canvas.drawCircle(posX2,posY2,radius, pen);
                    checkBounds(ball2);
                    posX2=ball2.getCoordinates().getxAxisPosition();
                    posY2=ball2.getCoordinates().getyAxisPosition();
                    checkForInversion(posX2,posY2,ball2);
                    checkForTouchingTopBottomBounds(posY2,ball2);

                    if(ball2.getCoordinates().getxAxisPosition()<=radius || ball2.getCoordinates().getxAxisPosition()>=screenWidth-radius){
                        shape2=SQUARE;
                        pen.setColor(ball2.getColor());
                        pen.setStrokeWidth(5);
                        pen.setStyle(Paint.Style.FILL);
                        int lastPosX=ball2.getCoordinates().getxAxisPosition();
                        int lastPosY=ball2.getCoordinates().getyAxisPosition();
                        canvas.drawRect(lastPosX-radius,lastPosY-radius,lastPosX+radius,lastPosY+radius,pen);
                        square2=new Square(lastPosX-radius,lastPosY-radius,lastPosX+radius,lastPosY+radius);
                        invalidate();
                        pen.reset();
                    }
                    invalidate();
                    pen.reset();
                }



                /* Ball 3 */
                if(shape3==CIRCLE){
                    pen.setColor(ball3.getColor());
                    pen.setStrokeWidth(5);
                    pen.setStyle(Paint.Style.FILL);
                    int posX3=ball3.getCoordinates().getxAxisPosition();
                    int posY3=ball3.getCoordinates().getyAxisPosition();
                    canvas.drawCircle(posX3,posY3,radius, pen);
                    checkBounds(ball3);
                    posX3=ball3.getCoordinates().getxAxisPosition();
                    posY3=ball3.getCoordinates().getyAxisPosition();
                    checkForInversion(posX3,posY3,ball3);
                    checkForTouchingTopBottomBounds(posY3,ball3);

                    if(ball3.getCoordinates().getxAxisPosition()<=radius || ball3.getCoordinates().getxAxisPosition()>=screenWidth-radius){
                        shape3=SQUARE;
                        pen.setColor(ball3.getColor());
                        pen.setStrokeWidth(5);
                        pen.setStyle(Paint.Style.FILL);
                        int lastPosX=ball3.getCoordinates().getxAxisPosition();
                        int lastPosY=ball3.getCoordinates().getyAxisPosition();
                        canvas.drawRect(lastPosX-radius,lastPosY-radius,lastPosX+radius,lastPosY+radius,pen);
                        square3=new Square(lastPosX-radius,lastPosY-radius,lastPosX+radius,lastPosY+radius);
                        invalidate();
                        pen.reset();
                    }

                    invalidate();
                    pen.reset();
                }

                 x1=ball1.getCoordinates().getxAxisPosition();
                 y1=ball1.getCoordinates().getyAxisPosition();
                 x2=ball2.getCoordinates().getxAxisPosition();
                 y2=ball2.getCoordinates().getyAxisPosition();
                 x3=ball3.getCoordinates().getxAxisPosition();
                 y3=ball3.getCoordinates().getyAxisPosition();
                 distance_1_2=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
                 distance_2_3=Math.sqrt(Math.pow(x3-x2,2)+Math.pow(y3-y2,2));
                 distance_1_3=Math.sqrt(Math.pow(x3-x1,2)+Math.pow(y3-y1,2));

                checkTransformations(distance_1_2, distance_2_3 ,distance_1_3);



                if(shape1==SQUARE){
                    pen.setColor(ball1.getColor());
                    pen.setStrokeWidth(5);
                    pen.setStyle(Paint.Style.FILL);
                    int lastPosX=ball1.getCoordinates().getxAxisPosition();
                    int lastPosY=ball1.getCoordinates().getyAxisPosition();
                    canvas.drawRect(lastPosX-radius,lastPosY-radius,lastPosX+radius,lastPosY+radius,pen);
                    invalidate();
                    pen.reset();
                }

                if(shape2==SQUARE){
                    pen.setColor(ball2.getColor());
                    pen.setStrokeWidth(5);
                    pen.setStyle(Paint.Style.FILL);
                    int lastPosX=ball2.getCoordinates().getxAxisPosition();
                    int lastPosY=ball2.getCoordinates().getyAxisPosition();
                    canvas.drawRect(lastPosX-radius,lastPosY-radius,lastPosX+radius,lastPosY+radius,pen);
                    invalidate();
                    pen.reset();
                }

                if(shape3==SQUARE){
                    pen.setColor(ball3.getColor());
                    pen.setStrokeWidth(5);
                    pen.setStyle(Paint.Style.FILL);
                    int lastPosX=ball3.getCoordinates().getxAxisPosition();
                    int lastPosY=ball3.getCoordinates().getyAxisPosition();
                    canvas.drawRect(lastPosX-radius,lastPosY-radius,lastPosX+radius,lastPosY+radius,pen);
                    invalidate();
                    pen.reset();
                }


                if(!newBallsList.isEmpty()){
                    for (Ball ball : newBallsList){
                        pen.setColor(Color.RED);
                        pen.setStrokeWidth(5);
                        pen.setStyle(Paint.Style.FILL);
                        int posX=ball.getCoordinates().getxAxisPosition();
                        int posY=ball.getCoordinates().getyAxisPosition();
                        canvas.drawCircle(posX,posY,radius,pen);
                        checkBounds(ball);
                        posX=ball.getCoordinates().getxAxisPosition();
                        posY=ball.getCoordinates().getyAxisPosition();
                        checkForInversion(posX,posY,ball);
                        checkForTouchingTopBottomBounds(posY,ball);

                        if(ball.getCoordinates().getxAxisPosition()<=radius || ball.getCoordinates().getxAxisPosition()>=screenWidth-radius){
                            shape1=SQUARE;
                            pen.setColor(ball.getColor());
                            pen.setStrokeWidth(5);
                            pen.setStyle(Paint.Style.FILL);
                            int lastPosX=ball.getCoordinates().getxAxisPosition();
                            int lastPosY=ball.getCoordinates().getyAxisPosition();
                            canvas.drawRect(lastPosX-radius,lastPosY-radius,lastPosX+radius,lastPosY+radius,pen);
                            square1=new Square(lastPosX-radius,lastPosY-radius,lastPosX+radius,lastPosY+radius);
                            invalidate();
                            pen.reset();
                        }
                        invalidate();
                        pen.reset();

                    }

                }



    }




    private void checkBounds(Ball ball) {
        int nextY=ball.getCoordinates().getyAxisPosition()+ ball.getStepSizeY();
        int nextX=ball.getCoordinates().getxAxisPosition() + ball.getStepSizeX();
        if(nextY<screenHeight-radius && nextY>radius){
            ball.getCoordinates().setyAxisPosition(nextY);
            ball.getCoordinates().setxAxisPosition(nextX);
        } else {
            ball.setStepSizeY(-ball.getStepSizeY());
            ball.setStepSizeX(-ball.getStepSizeX());
        }
    }

    private void checkTransformations(double distance_1_2, double distance_2_3, double distance_1_3) {
        if(shape1==CIRCLE && shape2==CIRCLE && distance_1_2<2*radius){

                Random random=new Random();
                int pos=random.nextInt(10);
                ballsList.get(0).setColor(colors[pos]);
                ballsList.get(0).setStepSizeY(invertStepSign(ballsList.get(0).getStepSizeY()));
                pos=random.nextInt(10);
                ballsList.get(1).setColor(colors[pos]);
                ballsList.get(1).setStepSizeY(invertStepSign(ballsList.get(1).getStepSizeY()));



        } else if(shape2==CIRCLE && shape3==CIRCLE && distance_2_3<2*radius){
                Random random=new Random();
                int pos=random.nextInt(10);
                ballsList.get(1).setColor(colors[pos]);
                ballsList.get(1).setStepSizeY(invertStepSign(ballsList.get(1).getStepSizeY()));
                pos=random.nextInt(10);
                ballsList.get(2).setColor(colors[pos]);
                ballsList.get(2).setStepSizeY(invertStepSign(ballsList.get(2).getStepSizeY()));


        } else if(shape1==CIRCLE && shape3==CIRCLE && distance_1_3<2*radius){
                Random random=new Random();
                int pos=random.nextInt(10);
                ballsList.get(0).setColor(colors[pos]);
                ballsList.get(0).setStepSizeY(invertStepSign(ballsList.get(0).getStepSizeY()));
                pos=random.nextInt(10);
                ballsList.get(2).setColor(colors[pos]);
                ballsList.get(2).setStepSizeY(invertStepSign(ballsList.get(2).getStepSizeY()));


        }

    }

    public void checkForInversion(int posX, int posY , Ball ball){
        int invertedX=0;
        int invertedY=0;
        if(posX>(screenWidth-radius) || posY>(screenHeight-radius)){
            invertedX=invertStepSign(ball.getStepSizeX());
            invertedY=invertStepSign(ball.getStepSizeY());
            ball.setStepSizeX(invertedX);
            ball.setStepSizeY(invertedY);
        }

        if(posX<radius || posY<radius){
            invertedX=invertStepSign(ball.getStepSizeX());
            invertedY=invertStepSign(ball.getStepSizeY());
            ball.setStepSizeX(invertedX);
            ball.setStepSizeY(invertedY);
        }

    }

    public void checkForTouchingTopBottomBounds(int posY ,Ball ball){
        if (posY<=radius+10 || posY>=screenHeight-radius+10){
            int stepX=ball.getStepSizeX();
            int stepY=ball.getStepSizeY();
            if(stepX>0 && stepY>0){
                ball.setStepSizeY(stepY+5);
            } else{
                ball.setStepSizeY(stepY-5);
            }
        }

    }

    public int invertStepSign(int step) {
            step=-step;
        return step;
    }

    @Override
    public void run() {
        try
        {
            Thread.sleep(1000, 1);
        }catch(InterruptedException e){}
    }



    public int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }


    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Ball ball1=ballsList.get(0);
        Ball ball2=ballsList.get(1);
        Ball ball3=ballsList.get(2);
        switch(keyCode){
            case KeyEvent.KEYCODE_VOLUME_UP:
                for(Ball ball: ballsList){
                    if(ball.getStepSizeY()>0){
                        ball.setStepSizeY(ball.getStepSizeY()+10);
                    } else {
                        ball.setStepSizeY(ball.getStepSizeY()-10);
                    }
                }
                /*ball1.setStepSizeY(ball1.getStepSizeY()+10);
                ball2.setStepSizeY(ball2.getStepSizeY()+10);
                ball3.setStepSizeY(ball3.getStepSizeY()+10);*/
                if(!newBallsList.isEmpty()){
                    for(Ball ball : newBallsList){
                        if(ball.getStepSizeY()>0){
                            ball.setStepSizeY(ball.getStepSizeY()+10);
                        } else {
                            ball.setStepSizeY(ball.getStepSizeY()-10);
                        }
                    }
                }
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                /*if(ball1.getStepSizeY()-10>0){
                    ball1.setStepSizeY(ball1.getStepSizeY()-10);
                }
                if(ball2.getStepSizeY()-10>0){
                    ball2.setStepSizeY(ball2.getStepSizeY()-10);
                }
                if(ball3.getStepSizeY()-10>0){
                    ball3.setStepSizeY(ball2.getStepSizeY()-10);
                }*/

                for(Ball ball: ballsList){
                    if(ball.getStepSizeY()>0 && ball.getStepSizeY()-10>0){
                        ball.setStepSizeY(ball.getStepSizeY()-10);
                    } else {
                        ball.setStepSizeY(ball.getStepSizeY()+10);
                    }
                }

                if(!newBallsList.isEmpty()){
                    for(Ball ball : newBallsList){
                        if(ball.getStepSizeY()>0 && ball.getStepSizeY()-10>0){
                            ball.setStepSizeY(ball.getStepSizeY()-10);
                        } else {
                            ball.setStepSizeY(ball.getStepSizeY()+10);
                        }
                    }
                }
                break;
        }



        return super.onKeyUp(keyCode, event);
    }



}
