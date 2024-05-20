package sample;
import java.util.Scanner;
//import java.util.Random;

public class bera31 {
	
	static int scan(Scanner sc, int num) {	//범위 지정 받아 입력 받는 함수
				int s;
		while(true) {
			s = sc.nextInt();
			for(int i=1; i<=num; i++)
				if(i == s) return s;		
			System.out.print("똑바로 입력 하세요: ");
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("컴퓨터와 베스킨라빈스 31 게임");
		System.out.print("순서 선택 (1선공 2후공): ");
		int first = scan(sc, 2);
		int count = 0;	//31까지 가는 수
		int sum = 0;		//더할 수
		
		switch(first) {
		case 1:	//플레이어 선공 게임
			while(true) {
				
				//플레이어 차례-------------------------------------------
				System.out.print("부를 숫자의 갯수(1~3): ");
				sum = scan(sc, 3);
				for(int i=0;i<sum;i++)
					if(++count != 31) 
						System.out.print(count + " ");
					else {
						System.out.print("31! 당신의 패배 입니다.");
						sc.close();
						return;
					}
				System.out.println();
				
				//컴퓨터 차례-------------------------------------------
				if(count == 1 || count == 30) sum = 1;
				else if( (count-2-sum) % 4 == 0)	sum = 4 - sum;
				else if(27<=count && count <=29)	sum = 30-count;
				else sum = (int)(Math.random()*3+1);	//1~3 랜덤 
				System.out.println("컴퓨터가 "+sum+"개의 수를 불렀습니다.");
				for(int i=0; i<sum; i++) {
					if(++count != 31) 
						System.out.print(count + " ");					
					else {
						System.out.print("31! 당신의 승리 입니다.");
						sc.close();
						return;
					}
				}
				System.out.println();
				System.out.println();
				
			}
			
		case 2:	//컴퓨터 선공 게임
			while(true) {
				//컴퓨터 차례---------------------------------
				if(sum == 0)	sum = 2;
				else sum = 4-sum;
				System.out.println("컴퓨터가 "+sum+"개의 수를 불렀습니다.");
				for(int i=0; i<sum; i++)
					System.out.print(++count + " ");
				System.out.println();
				
				//플레이어 차례-----------------------------------------
				System.out.print("부를 숫자의 갯수(1~3): ");
				sum = scan(sc, 3);
				for(int j=0;j<sum;j++)
					if(++count != 31) 
						System.out.print(count + " ");				
					else {
						System.out.print("31! 당신의 패배 입니다.");
						sc.close();
						return;
					}
				System.out.println();
				System.out.println();
			}
		}//switch
		
	}
}
