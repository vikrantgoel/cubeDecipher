package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cube.Cube;
import cube.Solve;

@SuppressWarnings("serial")
public class RubikCubeSolver extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] top=new String[9];
		String[] down=new String[9];
		String[] back=new String[9];
		String[] front=new String[9];
		String[] left=new String[9];
		String[] right=new String[9];

		for(int i=0; i<9; i++)
		{
			top[i]=request.getParameter("T"+(i+1));
			//System.out.println(top[i]);
		}
		for(int i=0; i<9; i++)
		{
			left[i]=request.getParameter("L"+(i+1));
			//System.out.println(left[i]);
		}
		for(int i=0; i<9; i++)
		{
			front[i]=request.getParameter("F"+(i+1));
			//System.out.println(front[i]);
		}
		for(int i=0; i<9; i++)
		{
			right[i]=request.getParameter("R"+(i+1));
			//System.out.println(right[i]);
		}
		for(int i=0; i<9; i++)
		{
			back[i]=request.getParameter("B"+(i+1));
			//System.out.println(back[i]);
		}
		for(int i=0; i<9; i++)
		{
			down[i]=request.getParameter("D"+(i+1));
			//System.out.println(down[i]);
		}
		Cube c = new Cube(top,down,front,back,left,right);
		final Solve s = new Solve(c);

		ExecutorService executor = Executors.newCachedThreadPool();
		Callable<Object> task = new Callable<Object>() {
			public Object call() {
				return s.displayMoves(false);
			}
		};
		Future<Object> future = executor.submit(task);
		String str="";
		try {
		   str=(String)future.get(10, TimeUnit.SECONDS);
		} catch (Exception e){
			str="Error, wrong inputs!";
			future.cancel(true);
		}

		PrintWriter pw = response.getWriter();
		pw.write(str);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
