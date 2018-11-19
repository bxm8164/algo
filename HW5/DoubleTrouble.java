import java.sql.SQLOutput;
import java.util.Scanner;

public class DoubleTrouble {
    public static Queue<State> states = new Queue<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] ab = sc.nextLine().split(" ");
        String[][] maze = new String[Integer.parseInt(ab[0])][Integer.parseInt(ab[1])];
        State init = new State(0,0,0,0,0, 0);

        for(int i = 0; i < Integer.parseInt(ab[0]); i++)
        {
            maze[i] = sc.nextLine().split("");
            for(int k = 0; k < Integer.parseInt(ab[1]); k++)
            {
                if(maze[i][k].equals("1"))
                {
                    init.x1 = i;
                    init.y1 = k;
                }

                if(maze[i][k].equals("2"))
                {
                    init.x2 = i;
                    init.y2 = k;
                }

            }

        }

        int i = 0;
        System.out.println(bfs(maze, init, Integer.parseInt(ab[0]), Integer.parseInt(ab[1])));


    }

    public static String bfs(String maze[][], State init, int a, int b)
    {
        states.enqueue(init);

        int min_moves = 0;
        boolean[][][][] seen = new boolean[a][b][a][b];
        seen[init.x1][init.y1][init.x2][init.y2] = true;

        while(!states.isEmpty())
        {
            State curr = states.dequeue();

            for(int i = 0; i < a; i++)
            {
                for(int j = 0; j < b; j++)
                {
                    if(i == curr.x1 && j == curr.y1 ) {
                        maze[i][j] = "1";
                        continue;
                    }
                    if(i == curr.x2 && j == curr.y2 )
                    {
                        maze[i][j] = "2";
                        continue;
                    }
                    else if(maze[i][j].equals("1") || maze[i][j].equals("2"))
                        maze[i][j] = ".";
                }
            }



            if(lefthouse(curr, a, b) && curr.dist1 == curr.dist2 && curr.dist1 > 0)
            {
                return Integer.toString(curr.dist1);

            }

            State[] valid_moves;
            valid_moves = find_next_moves(curr, a, b, maze);

            for(State s : valid_moves)
            {
                if(s != null)
                {
                    if(!seen[s.x1][s.y1][s.x2][s.y2])
                    {
                        states.enqueue(s);
                        seen[s.x1][s.y1][s.x2][s.y2] = true;
                    }


                }

            }

        }
        return "STUCK";
    }

    public static State[] find_next_moves(State state, int a, int b, String maze[][])
    {
        State[] states = new State[4];

        int i = 0;
        boolean east = false;
        boolean west = false;
        boolean north = false;
        boolean south = false;

            if(eastvalid(new Point(state.x1, state.y1+1), b, maze) && eastvalid(new Point(state.x2, state.y2+1), b, maze) )
            {
                State s = new State(state.x1, state.y1+1, state.x2, state.y2+1, state.dist1+1, state.dist2+1);
                states[i] = s;
                i++;


            }
            else if(eastvalid(new Point(state.x1, state.y1+1), b, maze) && !eastvalid(new Point(state.x2, state.y2+1), b, maze) )
            {
                State s = new State(state.x1, state.y1+1, state.x2, state.y2, state.dist1+1, state.dist2);
                states[i] = s;
                i++;

            }
            else if(!eastvalid(new Point(state.x1, state.y1+1), b, maze) && eastvalid(new Point(state.x2, state.y2+1), b, maze) )
            {
                State s = new State(state.x1, state.y1, state.x2, state.y2+1, state.dist1, state.dist2+1);
                states[i] = s;
                i++;

            }
            if(westvalid(new Point(state.x1, state.y1-1), b, maze) && westvalid(new Point(state.x2, state.y2-1), b, maze) )
            {
                State s = new State(state.x1, state.y1-1, state.x2, state.y2-1, state.dist1+1, state.dist2+1);
                states[i] = s;
                i++;



            }
            else if(westvalid(new Point(state.x1, state.y1-1), b, maze) && !westvalid(new Point(state.x2, state.y2-1), b, maze) )
            {
                State s = new State(state.x1, state.y1-1, state.x2, state.y2, state.dist1, state.dist2+1);
                states[i] = s;
                i++;


            }
            else if(!westvalid(new Point(state.x1, state.y1-1), b, maze) && westvalid(new Point(state.x2, state.y2-1), b, maze) )
            {
                State s = new State(state.x1, state.y1, state.x2, state.y2-1, state.dist1, state.dist2+1);
                states[i] = s;
                i++;


            }
            if(southvalid(new Point(state.x1+1, state.y1), a, maze) && southvalid(new Point(state.x2+1, state.y2), a, maze) )
            {
                State s = new State(state.x1+1, state.y1, state.x2+1, state.y2, state.dist1+1, state.dist2+1);
                states[i] = s;
                i++;


            }
            else if(southvalid(new Point(state.x1+1, state.y1), a, maze) && !southvalid(new Point(state.x2+1, state.y2), a, maze) )
            {
                State s = new State(state.x1+1, state.y1, state.x2, state.y2, state.dist1+1, state.dist2);
                states[i] = s;
                i++;



            }
            else if(!southvalid(new Point(state.x1+1, state.y1), a, maze) && southvalid(new Point(state.x2+1, state.y2), a, maze))
            {
                State s = new State(state.x1, state.y1, state.x2+1, state.y2, state.dist1, state.dist2+1);
                states[i] = s;
                i++;


            }
            if(northvalid(new Point(state.x1-1, state.y1), a, maze) && northvalid(new Point(state.x2-1, state.y2), a, maze) )
            {
                State s = new State(state.x1-1, state.y1, state.x2-1, state.y2, state.dist1+1, state.dist2+1);
                states[i] = s;
                i++;


            }
            else if(northvalid(new Point(state.x1-1, state.y1), a, maze) && !northvalid(new Point(state.x2-1, state.y2), a, maze))
            {
                State s = new State(state.x1-1, state.y1, state.x2, state.y2, state.dist1+1, state.dist2);
                states[i] = s;
                i++;

            }
            else if(!northvalid(new Point(state.x1-1, state.y1), a, maze) && northvalid(new Point(state.x2-1, state.y2), a, maze) )
            {
                State s = new State(state.x1, state.y1, state.x2-1, state.y2, state.dist1, state.dist2+1);
                states[i] = s;
                i++;
                north = true;
            }
            else
                {
                    i++;
                }


        return states;

    }

    public static boolean lefthouse(State p, int a, int b)
    {
        if(((p.x1 == 0 || p.x2 == a-1) || (p.x2 == 0 || p.x1 == a-1)) && ((p.y1 == 0 || p.y2 == b-1) || (p.y2 == 0 || p.y1 ==b-1)) )
            return true;

        return false;
    }

    public static boolean eastvalid(Point p, int b, String matrix[][])
    {
        if(p.y < b && p.y >=0 && matrix[p.x][p.y].equals("."))
            return true;
        return false;
    }

    public static boolean westvalid(Point p, int b, String matrix[][])
    {
        if(p.y >= 0 && p.y < b && matrix[p.x][p.y].equals("."))
            return true;
        return false;
    }

    public static boolean northvalid(Point p, int a, String matrix[][])
    {
        if(p.x >= 0 && p.x < a && matrix[p.x][p.y].equals("."))
            return true;
        return false;
    }

    public static boolean southvalid(Point p, int a, String matrix[][])
    {
        if(p.x < a && p.x >=0 && matrix[p.x][p.y].equals("."))
            return true;
        return false;
    }
}

class Point
{
    int x = 0;
    int y = 0;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

class State
{
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    int dist1 = 0;
    int dist2 = 0;

    public State(int x1, int y1, int x2, int y2, int dist1, int dist2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.dist1 = dist1;
        this.dist2 = dist2;
    }
}