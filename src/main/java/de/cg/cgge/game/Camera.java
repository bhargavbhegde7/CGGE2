package de.cg.cgge.game;

public class Camera {

    private int xpos = 0;
    private int ypos = 0;
    private int xpadding = 150;
    private int ypadding = 100;
    private int camSpeed = 5; 

    private double zoom = 1;

    private GameObject toFollow;

    private Room room; 


    /**
     * A Camera is used to navigate in space
     * Through a camera renderer, objects are able to directly draw themselves to the correct camera position
     * If you want a custom camera tracking, you should override public void update()
     * @param toFollow The object, the camera should be following 
     * @param room The room, the camera is located in
     */
    public Camera(GameObject toFollow, Room room) {
        this.toFollow = toFollow;
        this.room = room;
    }

    /**
     * Updates the camera based on the position of the target object
     */
    public void update() {
        if (toFollow != null) {

            float objX = toFollow.getX();
            float objY = toFollow.getY();

            if (objX-xpos < xpadding) {
                xpos -= camSpeed;
            }

            if (objX-xpos > room.getGameInstance().getWidth()-xpadding) {
                xpos += camSpeed;
            }

            if (objY-ypos < ypadding) {
                ypos -= camSpeed;
            }

            if (objY-ypos > room.getGameInstance().getHeight()-ypadding) {
                ypos += camSpeed;
            }
        }
    }

    /**
     * 
     * @return Returns the speed, at which the camera follows the target object
     */
    public int getSpeed() {
        return camSpeed; 
    }

    /**
     * 
     * @param speed The speed at which the camera should follow the target object
     */
    public void setSpeed(int speed) {
        this.camSpeed = speed;
    }
    
    public int getYpadding() {
        return ypadding;
    }
    
    /**
     * 
     * @param ypadding Sets the y-Padding of the object
     */
    public void setYpadding(int ypadding) {
        this.ypadding = ypadding;
    }

    public int getXpadding() {
        return xpadding;
    }

    /**
     * @param xpadding Sets the x-Padding of the object
     */
    public void setXpadding(int xpadding) {
        this.xpadding = xpadding;
    }

    public double getZoom() {
        return zoom;
    }

    /**
     * The camera zooms into the objects on screen
     * @param zoom The zoom factor
     */
    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    public int getY() {
        return ypos;
    }

    /**
     * 
     * @param ypos Sets the y-Position of the camera
     */
    public void setY(int ypos) {
        this.ypos = ypos;
    }

    public int getX() {
        return xpos;
    }

    /**
     * 
     * @param xpos Sets the x-Position of the object
     */
    public void setX(int xpos) {
        this.xpos = xpos;
    }

    /**
     * 
     * @param toFollow The object, the camera should follow
     */
    public void setObjectToFollow(GameObject toFollow) {
        this.toFollow = toFollow;
    }

    /**
     * Chechs wether a given rectangle is in view of the camera
     * @param x X position of upper left corner of the rectangle
     * @param y Y position of upper left corner of the rectangle
     * @param w The width of the rectangle
     * @param h The height
     * @return When the given arguments are in view of the camera, true is being returned
     */
    public boolean isInView(int x, int y, int w, int h) {
        
        if ( (x+w-xpos > 0) && (x-xpos <= room.getGameInstance().getWidth()) && ( y+h-ypos >= 0) && (y-ypos <= room.getGameInstance().getHeight()))  {
            return true; 
        }

        return false; 
    }

}