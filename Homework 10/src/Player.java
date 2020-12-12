import java.util.concurrent.atomic.AtomicInteger;
/**
 * A simple Player class which may cause race conditions in multi-thread program.
 * 
 */
public class Player {
	private int x;	//x position of the player
	//y position of the player
	private int hp;		//health point of the player
	private AtomicInteger y;
	public static Object obj = new Object();
	
	public Player(int x, int y, int hp){
		this.x = x;
		this.y = new AtomicInteger(y);
		this.hp = hp;
	}
	
	public void printPlayer(){
		System.out.printf("x position:\t%d\ny position:\t%s\nhealth point:\t%d\n", x, y, hp);
	}
	
	public void moveLeft(){
		synchronized(obj)
		{
			x--;
		}
	}
	public void moveRight(){
		synchronized(obj)
		{
			x++;
		}
	}
	
	public void moveUp(){
		y.set(y.getAndIncrement());
	}
	public void moveDown(){
		y.set(y.getAndDecrement());
	}
	
	public void loseHealth(){
		synchronized(obj)
		{
			hp --;
		}
	}
	
	public void gainHealth(){
		synchronized(obj)
		{
			hp ++;
		}
		
	}
	
}
