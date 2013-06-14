package cube;
import java.util.ArrayList;
public class Solve {

	public String movesDisplayString="";
	private Cube c;
	public Solve(Cube c){
		this.c = c;
	}

	//white cross methods
	private boolean checkWhiteCross(){
		if(		c.front[4].equals(c.front[7]) && c.down[1].equals(c.down[4]) &&
				c.right[4].equals(c.right[7]) && c.down[5].equals(c.down[4]) &&
				c.left[4].equals(c.left[7]) && c.down[3].equals(c.down[4]) &&
				c.back[4].equals(c.back[7]) && c.down[7].equals(c.down[4])
				){
			return true;
		}
		else{
			return false;
		}

	}
	private void whiteEdgeFromTopToDown(){
		if( c.top[1].equals(c.d) || c.top[3].equals(c.d) || c.top[5].equals(c.d) || c.top[7].equals(c.d) ){
			if(c.top[1].equals(c.d)){
				if(c.back[1].equals(c.b)){
					c.B().B();
				} else if(c.back[1].equals(c.l)){
					c.Ti().L().L();
				} else if(c.back[1].equals(c.r)){
					c.T().R().R();
				} else if(c.back[1].equals(c.f)){
					c.T().T().F().F();
				}
			} else if(c.top[3].equals(c.d)){
				if(c.left[1].equals(c.b)){
					c.T().B().B();
				} else if(c.left[1].equals(c.l)){
					c.L().L();
				} else if(c.left[1].equals(c.r)){
					c.T().T().R().R();
				} else if(c.left[1].equals(c.f)){
					c.Ti().F().F();
				}
			} else if(c.top[5].equals(c.d)){
				if(c.right[1].equals(c.b)){
					c.Ti().B().B();
				} else if(c.right[1].equals(c.l)){
					c.T().T().L().L();
				} else if(c.right[1].equals(c.r)){
					c.R().R();
				} else if(c.right[1].equals(c.f)){
					c.T().F().F();
				}
			} else if(c.top[7].equals(c.d)){
				if(c.front[1].equals(c.b)){
					c.T().T().B().B();
				} else if(c.front[1].equals(c.l)){
					c.T().L().L();
				} else if(c.front[1].equals(c.r)){
					c.Ti().R().R();
				} else if(c.front[1].equals(c.f)){
					c.F().F();
				}
			}
			whiteEdgeFromTopToDown();
		}
	}
	private void whiteEdgeFromDownToTop(){
		if(c.down[1].equals(c.d) && !c.front[7].equals(c.f)){
			c.F().F();
			whiteEdgeFromTopToDown();
			whiteEdgeFromDownToTop();
		} else if(c.down[3].equals(c.d) && !c.left[7].equals(c.l)){
			c.L().L();
			whiteEdgeFromTopToDown();
			whiteEdgeFromDownToTop();
		} else if(c.down[5].equals(c.d) && !c.right[7].equals(c.r)){
			c.R().R();
			whiteEdgeFromTopToDown();
			whiteEdgeFromDownToTop();
		} else if(c.down[7].equals(c.d) && !c.back[7].equals(c.b)){
			c.B().B();
			whiteEdgeFromTopToDown();
			whiteEdgeFromDownToTop();
		}
	}
	private void whiteEdgeFromMiddleSideToTop(){
		if(c.front[3].equals(c.d)){
			if(c.left[4].equals(c.left[7]) && c.down[3].equals(c.down[4]))
				c.Li().Ti().L();
			else
				c.Li();
			whiteEdgeFromTopToDown();
			whiteEdgeFromMiddleSideToTop();
		} else if(c.front[5].equals(c.d)){
			if(c.right[4].equals(c.right[7]) && c.down[5].equals(c.down[4]))
				c.R().T().Ri();
			else
				c.R();
			whiteEdgeFromTopToDown();
			whiteEdgeFromMiddleSideToTop();
		} else if(c.right[3].equals(c.d) || c.right[5].equals(c.d)){
			c.Axis();
			whiteEdgeFromMiddleSideToTop();
		} else if(c.left[3].equals(c.d) || c.left[5].equals(c.d)){
			c.Axisi();
			whiteEdgeFromMiddleSideToTop();
		} else if(c.back[3].equals(c.d) || c.back[5].equals(c.d)){
			c.Axis().Axis();
			whiteEdgeFromMiddleSideToTop();
		} 
	}
	private void whiteEdgeFromTopSideToDown(){
		if(c.front[1].equals(c.d)){
			if(c.top[7].equals(c.r)){
				if(c.front[4].equals(c.front[7]) && c.down[1].equals(c.down[4]))
					c.F().Ri().Fi();
				else
					c.F().Ri();

			} else if(c.top[7].equals(c.l)){
				if(c.front[4].equals(c.front[7]) && c.down[1].equals(c.down[4]))
					c.Fi().R().F();
				else
					c.Fi().R();
			} else{
				c.T();
			}
			whiteEdgeFromTopSideToDown();
		} else if(c.left[1].equals(c.d)){
			c.Axisi();
			whiteEdgeFromTopSideToDown();
		} else if(c.right[1].equals(c.d)){
			c.Axis();
			whiteEdgeFromTopSideToDown();
		} else if(c.back[1].equals(c.d)){
			c.Axis();
			c.Axis();
			whiteEdgeFromTopSideToDown();
		}
	}
	private void whiteEdgeFromDownSideToMiddleSide(){
		if(c.front[7].equals(c.d)){
			c.F();
			whiteEdgeFromMiddleSideToTop();
		} else if(c.left[7].equals(c.d)){
			c.L();
			whiteEdgeFromMiddleSideToTop();
		} else if(c.right[7].equals(c.d)){
			c.R();
			whiteEdgeFromMiddleSideToTop();
		} else if(c.back[7].equals(c.d)){
			c.B();
			whiteEdgeFromMiddleSideToTop();
		}
	}
	public Cube doWhiteCross(){
		while(!checkWhiteCross()){
			whiteEdgeFromTopToDown();
			if(checkWhiteCross())
				break;

			whiteEdgeFromDownToTop();
			if(checkWhiteCross())
				break;

			whiteEdgeFromMiddleSideToTop();
			if(checkWhiteCross())
				break;

			whiteEdgeFromTopSideToDown();
			if(checkWhiteCross())
				break;

			whiteEdgeFromDownSideToMiddleSide();
			if(checkWhiteCross())
				break;
		}
		return c;
	}

	//white face complete methods
	private boolean checkWhiteFace(){
		if( 	(c.down[0].equals(c.d) && c.left[8].equals(c.l) && c.front[6].equals(c.f))
				&&
				(c.down[2].equals(c.d) && c.right[6].equals(c.r) && c.front[8].equals(c.f))
				&&
				(c.down[6].equals(c.d) && c.left[6].equals(c.l) && c.back[8].equals(c.b))
				&&
				(c.down[8].equals(c.d) && c.right[8].equals(c.r) && c.back[6].equals(c.b))
				){
			return true;
		}
		else
			return false;
	}
	private void whiteCornerTopLayerToDown(){
		if(		c.front[0].equals(c.d) || c.front[2].equals(c.d)
				|| 
				c.right[0].equals(c.d) || c.right[2].equals(c.d)
				|| 
				c.back[0].equals(c.d) || c.back[2].equals(c.d)
				|| 
				c.left[0].equals(c.d) || c.left[2].equals(c.d)
				){
			if(c.right[0].equals(c.d) || c.left[0].equals(c.d) || c.back[0].equals(c.d) || c.front[0].equals(c.d)){
				if(c.right[0].equals(c.d)){
					c.Axis();
				} else if(c.left[0].equals(c.d)){
					c.Axisi();
				} else if(c.back[0].equals(c.d)){
					c.Axis().Axis();
				}

				if(!c.left[2].equals(c.l)){
					if(c.left[2].equals(c.f)){
						c.Ti();
					} else if(c.left[2].equals(c.r)){
						c.Ti().Ti().Axis();
					} else if(c.left[2].equals(c.b)){
						c.T().Axis().Axis();
					}
				}else{
					c.Axisi();
				}

				c.R().T().Ri();
			} else{
				if(c.right[2].equals(c.d)){
					c.Axis();
				} else if(c.left[2].equals(c.d)){
					c.Axisi();
				} else if(c.back[2].equals(c.d)){
					c.Axis().Axis();
				}

				if(!c.right[0].equals(c.r)){
					if(c.right[0].equals(c.f)){
						c.T();
					} else if(c.right[0].equals(c.l)){
						c.T().T().Axisi();
					} else if(c.right[0].equals(c.b)){
						c.Ti().Axis().Axis();
					}
				}else{
					c.Axis();
				}

				c.Li().Ti().L();
			}
			whiteCornerTopLayerToDown();
		}
	}
	private void whiteCornerBottomLayerToTopLayer(){
		if(		(c.front[6].equals(c.d) || c.front[8].equals(c.d))
				||
				(c.right[6].equals(c.d) || c.right[8].equals(c.d))
				||
				(c.left[6].equals(c.d) || c.left[8].equals(c.d))
				||
				(c.back[6].equals(c.d) || c.back[8].equals(c.d))
				){
			if(c.front[6].equals(c.d) || c.right[6].equals(c.d) || c.left[6].equals(c.d) || c.back[6].equals(c.d)){
				if(!c.front[6].equals(c.d)){
					if(c.right[6].equals(c.d)){
						c.Axis();
					}else if(c.left[6].equals(c.d)){
						c.Axisi();
					}else{
						c.Axis().Axis();
					}
				}
				c.F().T().Fi();
			}else{
				if(!c.front[8].equals(c.d)){
					if(c.right[8].equals(c.d)){
						c.Axis();
					}else if(c.left[8].equals(c.d)){
						c.Axisi();
					}else{
						c.Axis().Axis();
					}
				}
				c.Fi().Ti().F();
			}
			whiteCornerTopLayerToDown();	
		}
	}
	private void whiteCornerTopFaceToTopLayer(){
		if(c.top[0].equals(c.d) || c.top[2].equals(c.d) || c.top[6].equals(c.d) || c.top[8].equals(c.d)){
			if(c.top[0].equals(c.d))
				c.Axisi();
			else if(c.top[2].equals(c.d))
				c.Axis().Axis();
			else if(c.top[8].equals(c.d))
				c.Axis();
			if(c.down[0].equals(c.d) && c.left[8].equals(c.l) && c.front[6].equals(c.f)){
				if(!(c.down[2].equals(c.d) && c.right[6].equals(c.l) && c.front[8].equals(c.f))){
					c.Ti().Axis();
				} else if(!(c.down[6].equals(c.d) && c.left[6].equals(c.l) && c.back[8].equals(c.b))){
					c.T().Axisi();
				} else{
					c.T().T().Axis().Axis();
				}
			}
			c.Ri().T().R();
			whiteCornerTopLayerToDown();
		}
	}
	private void whiteDownFaceToTopFace(){
		if(c.down[0].equals(c.d) && c.front[6].equals(c.f) && c.left[8].equals(c.l)){
			if(!(c.down[2].equals(c.d) && c.front[8].equals(c.f) && c.right[6].equals(c.r))){
				c.Axis();
			}else if(!(c.down[0].equals(c.d) && c.front[6].equals(c.f) && c.left[8].equals(c.l))){
				c.Axis().Axis();
			}
		}
		c.Li().Ti().L();
		whiteCornerTopLayerToDown();
	}
	public Cube doWhiteFace(){
		while(!checkWhiteFace()){
			whiteCornerTopLayerToDown();
			if(checkWhiteFace())
				break;

			whiteCornerBottomLayerToTopLayer();
			if(checkWhiteFace())
				break;

			whiteCornerTopFaceToTopLayer();
			if(checkWhiteFace())
				break;

			whiteDownFaceToTopFace();
			if(checkWhiteFace())
				break;
		}
		return c;
	}

	//last2rows complete methods
	private boolean checkLast2Rows(){
		if(		c.front[3].equals(c.f) && c.left[5].equals(c.l)
				&&
				c.front[5].equals(c.f) && c.right[3].equals(c.r)
				&&
				c.back[5].equals(c.b) && c.left[3].equals(c.l)
				&&
				c.back[3].equals(c.b) && c.right[5].equals(c.r)
				)
			return true;
		else
			return false;
	}
	private void nonTopEdgeToMiddle(){
		if(!c.front[1].equals(c.t) && !c.top[7].equals(c.t)){
			if(!c.front[1].equals(c.f)){
				if(c.front[1].equals(c.r)){
					c.Ti().Axis();
				}else if(c.front[1].equals(c.l)){
					c.T().Axisi();
				}else{
					c.T().T().Axis().Axis();
				}
			}
			if(c.top[7].equals(c.l)){
				c.Ti().Li().Ti().L().T().Axisi().R().T().Ri();
			}else{
				c.T().R().T().Ri().Ti().Axis().Li().Ti().L();
			}
			nonTopEdgeToMiddle();
		}
		if(!c.left[1].equals(c.t) && !c.top[3].equals(c.t)){
			c.Axisi();
			nonTopEdgeToMiddle();
		}
		if(!c.right[1].equals(c.t) && !c.top[5].equals(c.t)){
			c.Axis();
			nonTopEdgeToMiddle();
		}
		if(!c.back[1].equals(c.t) && !c.top[1].equals(c.t)){
			c.Axis().Axis();
			nonTopEdgeToMiddle();
		}
	}
	private void wrongMiddleEdgeToRightMiddle(){
		if(!c.front[3].equals(c.f) || !c.left[5].equals(c.l)){
			c.Li().Ti().L();
			whiteCornerTopLayerToDown();
			nonTopEdgeToMiddle();
			wrongMiddleEdgeToRightMiddle();
		}else if(!c.front[5].equals(c.f) || !c.right[3].equals(c.r)){
			c.R().T().Ri();
			whiteCornerTopLayerToDown();
			nonTopEdgeToMiddle();
			wrongMiddleEdgeToRightMiddle();
		}else if(!c.back[5].equals(c.b) || !c.left[3].equals(c.l)){
			c.Axisi();
			wrongMiddleEdgeToRightMiddle();
		}else if(!c.back[3].equals(c.b) || !c.right[5].equals(c.r)){
			c.Axis();
			wrongMiddleEdgeToRightMiddle();
		}
	}
	public Cube doLastTwoRows(){
		while(!checkLast2Rows()){
			nonTopEdgeToMiddle();
			if(checkLast2Rows())
				break;

			wrongMiddleEdgeToRightMiddle();
			if(checkLast2Rows())
				break;
		}
		return c;
	}

	//top cross
	private boolean checkTopCross(){
		if(c.top[1].equals(c.t) && c.top[3].equals(c.t)  && c.top[5].equals(c.t)  && c.top[7].equals(c.t) ){
			return true;
		}else
			return false;
	}
	private boolean checkTopL(){
		if(c.top[1].equals(c.t) && c.top[3].equals(c.t) ){
			return true;
		}else if(c.top[1].equals(c.t) && c.top[5].equals(c.t) ){
			c.Ti();
			return true;
		}else if(c.top[5].equals(c.t) && c.top[7].equals(c.t) ){
			c.T().T();
			return true;
		}else if(c.top[3].equals(c.t) && c.top[7].equals(c.t) ){
			return true;
		}else
			return false;
	}
	private boolean checkTopLine(){
		if(c.top[1].equals(c.t) && c.top[7].equals(c.t) ){
			c.T();
			return true;
		}else if(c.top[3].equals(c.t) && c.top[5].equals(c.t) ){
			return true;
		}
		else return false;
	}
	private void topCrossAlgo(){
		c.F().T().R().Ti().Ri().Fi();
	}
	public Cube doTopCross(){
		while(!checkTopCross()){
			while(!checkTopL()){
				while(!checkTopLine()){
					topCrossAlgo();
				}
				topCrossAlgo();
			}
			topCrossAlgo();
		}
		return c;
	} 

	//top face
	private boolean checkTopFace(){
		boolean temp=true;
		for(String str:c.top){
			if(!str.equals(c.t)){
				temp=false;
				break;
			}
		}
		return temp;
	}
	private void TopFaceAlgo(){
		c.R().T().Ri().T().R().T().T().Ri();
	}
	private void alignForTopAlgo(){
		int freeCorners=0;
		if(!c.top[0].equals(c.t))
			freeCorners++;
		if(!c.top[2].equals(c.t))
			freeCorners++;
		if(!c.top[6].equals(c.t))
			freeCorners++;
		if(!c.top[8].equals(c.t))
			freeCorners++;


		if(freeCorners==4){
			if(c.left[0].equals(c.t) && c.left[2].equals(c.t)){
				return;
			}else if(c.right[0].equals(c.t) && c.right[2].equals(c.t)){
				c.T().T();
				return;
			}else if(c.front[0].equals(c.t) && c.front[2].equals(c.t)){
				c.T();
				return;
			}else{
				c.Ti();
				return;
			}
		}else if(freeCorners==3){
			if(c.top[6].equals(c.t)){
				return;
			}else if(c.top[8].equals(c.t)){
				c.T();
				return;
			}else if(c.top[2].equals(c.t)){
				c.T().T();
				return;
			}else{
				c.Ti();
				return;
			}
		}else if(freeCorners==2){
			if(c.top[0].equals(c.t) && c.top[2].equals(c.t)){
				return;
			}else if(c.top[8].equals(c.t) && c.top[2].equals(c.t)){
				c.Ti();
				return;
			}else if(c.top[8].equals(c.t) && c.top[6].equals(c.t)){
				c.T().T();
				return;
			}else if(c.top[0].equals(c.t) && c.top[6].equals(c.t)){
				c.T();
				return;
			}else if(c.top[0].equals(c.t) && c.top[8].equals(c.t)){
				return;
			}else{
				c.T();
				return;
			}
		}
	}
	public Cube doTopFace(){
		while(!checkTopFace()){
			alignForTopAlgo();
			TopFaceAlgo();
		}
		return c;
	} 

	//top corners
	private boolean checkTopCorners(){
		if(		c.front[0].equals(c.front[2])
				&&
				c.left[0].equals(c.left[2])
				&&
				c.right[0].equals(c.right[2])
				&&
				c.back[0].equals(c.back[2])){
			return true;
		}
		return false;
	}
	private void TopCornersAlgo(){
		c.Ri().F().Ri().B().B().R().Fi().Ri().B().B().R().R();
	}
	private void alignTopCorners(){
		if(c.front[0].equals(c.front[2])){
			c.T().T();
		}else if (c.left[0].equals(c.left[2])){
			c.T();
		}else if(c.right[0].equals(c.right[2])){
			c.Ti();
		}
	}
	public Cube doTopCorners(){
		while(!checkTopCorners()){
			alignTopCorners();
			TopCornersAlgo();
		}
		if(!c.front[0].equals(c.f)){
			if(c.front[0].equals(c.r)){
				c.Ti();
			}else if(c.front[0].equals(c.l)){
				c.T();
			}else if(c.front[0].equals(c.b)){
				c.T().T();
			}
		}
		return c;
	}

	//top edges
	private boolean checkTopEdges(){
		if(c.front[1].equals(c.f) && c.left[1].equals(c.l))
			return true;
		return false;
	}
	private void doExchangeCrossAcross(){
		c.L().L().R().R().D().L().L().R().R().T().T().R().R().L().L().D().R().R().L().L();
	}
	private void doExchangeCrossSideways(){
		if(!c.front[1].equals(c.r)){
			c.Axis();
		}
		c.L().L().R().R().D().L().L().R().R().T().Li().R().B().B().L().L().R().R().F().F().Li().R().T().T();
	}
	private void doClockwiseExchange(){
		c.R().Ti().R().T().R().T().R().Ti().Ri().Ti().R().R();
	}
	private void doAntiClockwiseExchange(){
		c.R().R().T().R().T().Ri().Ti().Ri().Ti().Ri().T().Ri();
	}
	private void alignForTopEdgeExchange(){
		if(c.front[1].equals(c.f))
			c.Axis().Axis();
		else if(c.left[1].equals(c.l))
			c.Axis();
		else if(c.right[1].equals(c.r))
			c.Axisi();
	}
	public Cube doTopEdges(){
		if(!checkTopEdges())
		{
			int improperEdges=0;
			if(!c.front[1].equals(c.f))
				improperEdges++;
			if(!c.left[1].equals(c.l))
				improperEdges++;
			if(!c.right[1].equals(c.r))
				improperEdges++;
			if(!c.back[1].equals(c.b))
				improperEdges++;

			if(improperEdges==4){
				if(c.front[1].equals(c.b))
					doExchangeCrossAcross();
				else
					doExchangeCrossSideways();
			}else{
				alignForTopEdgeExchange();
				if(c.front[1].equals(c.r)){
					doClockwiseExchange();
				}else{
					doAntiClockwiseExchange();
				}
			}
		}
		return c;
	}

	public Solve solve(){
		doWhiteCross();
		c.moves.add("1:WhiteCross moves");
		doWhiteFace();
		c.moves.add("2:WhiteFace moves");
		doLastTwoRows();
		c.moves.add("3:Last2Rows moves");
		doTopCross();
		c.moves.add("4:TopCross moves");
		doTopFace();
		c.moves.add("5:TopFace moves");
		doTopCorners();
		c.moves.add("6:TopCorners moves");
		doTopEdges();
		c.moves.add("7:TopEdges moves");
		return this;
	}
	
	public ArrayList<String> optimizeMoves(ArrayList<String> moves){
		if(moves.size()>1){
			ArrayList<String> al;
			boolean flag;
			do{
				flag=false;

				String last = moves.remove(0);
				al = new ArrayList<String>();
				al.add(last);

				for(String s:moves){
					if(s.length()!=last.length()){
						if(s.length()>last.length()){
							if(s.substring(0, 1).equals(last)){
								flag=true;
								al.remove(al.size()-1);
							} else
								al.add(s);
						}else{
							if(last.substring(0, 1).equals(s)){
								flag=true;
								al.remove(al.size()-1);
							} else
								al.add(s);
						}
					} else{
						al.add(s);
					}
					last=s;
				}
				moves.clear();
				moves.addAll(al);
			}while(flag && moves.size()>0);

			if(al.size()>2){
				for(int i=0;i<al.size()-2;i++){
					if(al.get(i+2).equals(al.get(i)) && al.get(i+1).equals(al.get(i))){
						String temp = al.get(i);
						al.remove(i);
						al.remove(i);
						al.remove(i);
						if(temp.length()==1)
							al.add(i, temp+"i");
						else
							al.add(i, temp.substring(0,1));
					}
				}
			}
			return al;
		}
		return moves;
	}
	public ArrayList<String> getMoves(){
		if(c.moves.isEmpty())
			solve();
		c.moves = optimizeMoves(c.moves);
		return c.moves;
	}

	public String displayMoves(boolean flag){
		StringBuffer buf1 = new StringBuffer();
		StringBuffer buf2 = new StringBuffer();
		getMoves();
		for(String s:c.moves){
			if(s.toCharArray()[0]>='0' && s.toCharArray()[0]<='9'){
				buf2.append("\n"+s+"\n");
				buf2.append(buf1);
				buf1.setLength(0);
			}else
				buf1.append(s+"\t");
		}
		if(flag)
			System.out.println(buf2);
		movesDisplayString = buf2.toString();
		return movesDisplayString;
	}
	public void display(){
		c.display();
	}
}