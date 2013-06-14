package cube;
import java.util.ArrayList;

/**
 * 
 * @author vikrantgoel
 *	1. Yellow
 *	2. Green
 *	3. Orange
 *	4. Blue
 *	5. Red
 *	6. White
 */
class CubeCopy {

	public String[] top=new String[9];
	public String[] down=new String[9];
	public String[] back=new String[9];
	public String[] front=new String[9];
	public String[] left=new String[9];
	public String[] right=new String[9];
}
public class Cube {

	String t="";
	String d="";
	String l="";
	String r="";
	String f="";
	String b="";
	
	ArrayList<String> moves = new ArrayList<String>();
	
	String[] top=new String[9];
	String[] down=new String[9];
	String[] back=new String[9];
	String[] front=new String[9];
	String[] left=new String[9];
	String[] right=new String[9];
	public CubeCopy copy = new CubeCopy();

	public Cube(){
		String[] top=new String[9];
		String[] down=new String[9];
		String[] back=new String[9];
		String[] front=new String[9];
		String[] left=new String[9];
		String[] right=new String[9];
		for(int i=0;i<9;i++){
			top[i]="Y";
			front[i]="G";
			right[i]="O";
			back[i]="B";
			left[i]="R";
			down[i]="W";
		}

		this.top=top;
		this.down=down;
		this.front=front;
		this.back=back;
		this.right=right;
		this.left=left;
		t=top[4];
		d=down[4];
		r=right[4];
		l=left[4];
		f=front[4];
		b=back[4];
	}
	public Cube(String[] top,String[] down,String[] front,String[] back,String[] left,String[] right){
		this.top=top;
		this.down=down;
		this.front=front;
		this.back=back;
		this.right=right;
		this.left=left;
		t=top[4];
		d=down[4];
		r=right[4];
		l=left[4];
		f=front[4];
		b=back[4];
	}
	
	public void display(){
		System.out.println();
		System.out.println("Top");
		for(int i=0;i<9;i++){
			System.out.print(top[i]+"\t");
			if((i+1)%3 == 0)
				System.out.println();
		}
		System.out.println();
		System.out.println("Front");
		for(int i=0;i<9;i++){
			System.out.print(front[i]+"\t");
			if((i+1)%3 == 0)
				System.out.println();
		}
		System.out.println();
		System.out.println("Right");
		for(int i=0;i<9;i++){
			System.out.print(right[i]+"\t");
			if((i+1)%3 == 0)
				System.out.println();
		}
		System.out.println();
		System.out.println("Back");
		for(int i=0;i<9;i++){
			System.out.print(back[i]+"\t");
			if((i+1)%3 == 0)
				System.out.println();
		}
		System.out.println();
		System.out.println("Left");
		for(int i=0;i<9;i++){
			System.out.print(left[i]+"\t");
			if((i+1)%3 == 0)
				System.out.println();
		}
		System.out.println();
		System.out.println("Down");
		for(int i=0;i<9;i++){
			System.out.print(down[i]+"\t");
			if((i+1)%3 == 0)
				System.out.println();
		}
	}
	
	public void doCopy(){
		for(int i=0;i<9;i++){
			copy.top[i]=top[i];
			copy.down[i]=down[i];
			copy.front[i]=front[i];
			copy.back[i]=back[i];
			copy.left[i]=left[i];
			copy.right[i]=right[i];
		}
	}

	public Cube L(){
		moves.add("L");
		doCopy();
		left[0]=copy.left[6];
		left[1]=copy.left[3];
		left[2]=copy.left[0];
		left[3]=copy.left[7];
		left[4]=copy.left[4];
		left[5]=copy.left[1];
		left[6]=copy.left[8];
		left[7]=copy.left[5];
		left[8]=copy.left[2];

		for(int i=1; i<10; i=i+3)
		{
			down[i-1]=front[i-1];
			front[i-1]=top[i-1];
			top[i-1]=back[(10-i-1)];
			back[(10-i-1)]=copy.down[i-1];
		}
		return this;
	}
	public Cube Li(){
		moves.add("Li");
		doCopy();
		left[0]=copy.left[2];
		left[1]=copy.left[5];
		left[2]=copy.left[8];
		left[3]=copy.left[1];
		left[4]=copy.left[4];
		left[5]=copy.left[7];
		left[6]=copy.left[0];
		left[7]=copy.left[3];
		left[8]=copy.left[6];

		for(int i=1; i<10; i=i+3)
		{
			top[i-1]=front[i-1];
			front[i-1]=down[i-1];
			down[i-1]=back[(10-i-1)];
			back[(10-i-1)]=copy.top[i-1];
		}
		return this;
	}

	public Cube R(){
		moves.add("R");
		doCopy();
		right[0]=copy.right[6];
		right[1]=copy.right[3];
		right[2]=copy.right[0];
		right[3]=copy.right[7];
		right[4]=copy.right[4];
		right[5]=copy.right[1];
		right[6]=copy.right[8];
		right[7]=copy.right[5];
		right[8]=copy.right[2];

		for(int i=3; i<10; i=i+3)
		{
			top[i-1]=front[i-1];
			front[i-1]=down[i-1];
			down[i-1]=back[(10-i-1)];
			back[(10-i-1)]=copy.top[i-1];
		}
		return this;
	}
	public Cube Ri(){
		moves.add("Ri");
		doCopy();
		right[0]=copy.right[2];
		right[1]=copy.right[5];
		right[2]=copy.right[8];
		right[3]=copy.right[1];
		right[4]=copy.right[4];
		right[5]=copy.right[7];
		right[6]=copy.right[0];
		right[7]=copy.right[3];
		right[8]=copy.right[6];

		for(int i=3; i<10; i=i+3)
		{
			down[i-1]=front[i-1];
			front[i-1]=top[i-1];
			top[i-1]=back[(10-i-1)];
			back[(10-i-1)]=copy.down[i-1];
		}
		return this;
	}

	public Cube F(){
		moves.add("F");
		doCopy();
		front[0]=copy.front[6];
		front[1]=copy.front[3];
		front[2]=copy.front[0];
		front[3]=copy.front[7];
		front[4]=copy.front[4];
		front[5]=copy.front[1];
		front[6]=copy.front[8];
		front[7]=copy.front[5];
		front[8]=copy.front[2];

		top[6] = left[8];
		top[7] = left[5];
		top[8] = left[2];

		left[8] = down[2];
		left[5] = down[1];
		left[2] = down[0];

		down[0] = right[6];
		down[1] = right[3];
		down[2] = right[0];

		right[6] = copy.top[8];
		right[3] = copy.top[7];
		right[0] = copy.top[6];

		return this;
	}
	public Cube Fi(){
		moves.add("Fi");
		doCopy();
		front[0]=copy.front[2];
		front[1]=copy.front[5];
		front[2]=copy.front[8];
		front[3]=copy.front[1];
		front[4]=copy.front[4];
		front[5]=copy.front[7];
		front[6]=copy.front[0];
		front[7]=copy.front[3];
		front[8]=copy.front[6];

		top[6] = right[0];
		top[7] = right[3];
		top[8] = right[6];

		right[0] = down[2];
		right[3] = down[1];
		right[6] = down[0];

		down[0] = left[2];
		down[1] = left[5];
		down[2] = left[8];

		left[2] = copy.top[8];
		left[5] = copy.top[7];
		left[8] = copy.top[6];

		return this;
	}

	public Cube B(){
		moves.add("B");
		doCopy();
		back[0]=copy.back[6];
		back[1]=copy.back[3];
		back[2]=copy.back[0];
		back[3]=copy.back[7];
		back[4]=copy.back[4];
		back[5]=copy.back[1];
		back[6]=copy.back[8];
		back[7]=copy.back[5];
		back[8]=copy.back[2];

		top[0] = right[2];
		top[1] = right[5];
		top[2] = right[8];

		right[8] = down[6];
		right[5] = down[7];
		right[2] = down[8];

		down[6] = left[0];
		down[7] = left[3];
		down[8] = left[6];

		left[6] = copy.top[0];
		left[3] = copy.top[1];
		left[0] = copy.top[2];

		return this;
	}
	public Cube Bi(){
		moves.add("Bi");
		doCopy();
		back[0]=copy.back[2];
		back[1]=copy.back[5];
		back[2]=copy.back[8];
		back[3]=copy.back[1];
		back[4]=copy.back[4];
		back[5]=copy.back[7];
		back[6]=copy.back[0];
		back[7]=copy.back[3];
		back[8]=copy.back[6];

		top[0] = left[6];
		top[1] = left[3];
		top[2] = left[0];

		left[6] = down[8];
		left[3] = down[7];
		left[0] = down[6];

		down[6] = right[8];
		down[7] = right[5];
		down[8] = right[2];

		right[8] = copy.top[2];
		right[5] = copy.top[1];
		right[2] = copy.top[0];

		return this;
	}

	public Cube T(){
		moves.add("T");
		doCopy();
		top[0]=copy.top[6];
		top[1]=copy.top[3];
		top[2]=copy.top[0];
		top[3]=copy.top[7];
		top[4]=copy.top[4];
		top[5]=copy.top[1];
		top[6]=copy.top[8];
		top[7]=copy.top[5];
		top[8]=copy.top[2];

		front[0] = right[0];
		front[1] = right[1];
		front[2] = right[2];

		right[0] = back[0];
		right[1] = back[1];
		right[2] = back[2];

		back[0] = left[0];
		back[1] = left[1];
		back[2] = left[2];

		left[0] = copy.front[0];
		left[1] = copy.front[1];
		left[2] = copy.front[2];

		return this;
	}
	public Cube Ti(){
		moves.add("Ti");
		doCopy();
		top[0]=copy.top[2];
		top[1]=copy.top[5];
		top[2]=copy.top[8];
		top[3]=copy.top[1];
		top[4]=copy.top[4];
		top[5]=copy.top[7];
		top[6]=copy.top[0];
		top[7]=copy.top[3];
		top[8]=copy.top[6];

		front[0] = left[0];
		front[1] = left[1];
		front[2] = left[2];

		left[0] = back[0];
		left[1] = back[1];
		left[2] = back[2];

		back[0] = right[0];
		back[1] = right[1];
		back[2] = right[2];

		right[0] = copy.front[0];
		right[1] = copy.front[1];
		right[2] = copy.front[2];

		return this;
	}

	public Cube D(){
		moves.add("D");
		doCopy();

		down[0]=copy.down[6];
		down[1]=copy.down[3];
		down[2]=copy.down[0];
		down[3]=copy.down[7];
		down[4]=copy.down[4];
		down[5]=copy.down[1];
		down[6]=copy.down[8];
		down[7]=copy.down[5];
		down[8]=copy.down[2];

		front[6] = left[6];
		front[7] = left[7];
		front[8] = left[8];

		left[8] = back[8];
		left[7] = back[7];
		left[6] = back[6];

		back[6] = right[6];
		back[7] = right[7];
		back[8] = right[8];

		right[6] = copy.front[6];
		right[7] = copy.front[7];
		right[8] = copy.front[8];

		return this;
	}
	public Cube Di(){
		moves.add("Di");
		doCopy();

		down[0]=copy.down[2];
		down[1]=copy.down[5];
		down[2]=copy.down[8];
		down[3]=copy.down[1];
		down[4]=copy.down[4];
		down[5]=copy.down[7];
		down[6]=copy.down[0];
		down[7]=copy.down[3];
		down[8]=copy.down[6];

		front[6] = right[6];
		front[7] = right[7];
		front[8] = right[8];

		right[8] = back[8];
		right[7] = back[7];
		right[6] = back[6];

		back[6] = left[6];
		back[7] = left[7];
		back[8] = left[8];

		left[6] = copy.front[6];
		left[7] = copy.front[7];
		left[8] = copy.front[8];

		return this;
	}

	public Cube Axis(){
		moves.add("A");
		doCopy();
		down[0]=copy.down[2];
		down[1]=copy.down[5];
		down[2]=copy.down[8];
		down[3]=copy.down[1];
		down[4]=copy.down[4];
		down[5]=copy.down[7];
		down[6]=copy.down[0];
		down[7]=copy.down[3];
		down[8]=copy.down[6];
		top[0]=copy.top[6];
		top[1]=copy.top[3];
		top[2]=copy.top[0];
		top[3]=copy.top[7];
		top[4]=copy.top[4];
		top[5]=copy.top[1];
		top[6]=copy.top[8];
		top[7]=copy.top[5];
		top[8]=copy.top[2];
		String[] temp = front;
		front=right;
		right=back;
		back=left;
		left=temp;
		r=right[4];
		l=left[4];
		f=front[4];
		b=back[4];
		return this;
	}
	public Cube Axisi(){
		moves.add("Ai");
		doCopy();
		down[0]=copy.down[6];
		down[1]=copy.down[3];
		down[2]=copy.down[0];
		down[3]=copy.down[7];
		down[4]=copy.down[4];
		down[5]=copy.down[1];
		down[6]=copy.down[8];
		down[7]=copy.down[5];
		down[8]=copy.down[2];
		top[0]=copy.top[2];
		top[1]=copy.top[5];
		top[2]=copy.top[8];
		top[3]=copy.top[1];
		top[4]=copy.top[4];
		top[5]=copy.top[7];
		top[6]=copy.top[0];
		top[7]=copy.top[3];
		top[8]=copy.top[6];
		String[] temp = front;
		front=left;
		left=back;
		back=right;
		right=temp;
		r=right[4];
		l=left[4];
		f=front[4];
		b=back[4];
		return this;
	}
	
	public static void main(String g[]){

		Cube c = new Cube();
		
		//c.R().Ti().R().T().R().T().R().Ti().Ri().Ti().R().R();
		c.Li().Ti().D().Axis();
		//c.display();
		c.moves = new ArrayList<String>(); //important
		
		//Solve start
		Solve s = new Solve(c);
		s.solve();
		
		System.out.println(s.getMoves());
		s.displayMoves(true);
	}
}