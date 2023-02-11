import java.util.*;
import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 년도는 항상 2021
// 대여기간 날짜가 최대 200 -> 1~12월 전부 날짜에 맞춰 계산해야함
 
public class Main {

    static long[] monthTime;

	private static long getMonthTime(int month) {
		// TODO Auto-generated method stub

		if (month == 0)
			return 0;

		if (monthTime[month] == 0) {
			int day;
			if (month == 4 || month == 6 || month == 9 || month == 11)
				day = 30;
			else if (month == 2)
				day = 28;
			else
				day = 31;
			return monthTime[month] = getMonthTime(month - 1) + (1440 * day);
		} else
			return monthTime[month];
	}
 
    static int N, F ; // 작성된 정보의 개수, 벌금
    static String L ; // 대여기간
    static long rentalMTime; // 대여 기간을 분으로 표시

    static HashMap<String, HashMap<String, Long> > hm ;
    static HashMap<String, Long> resultHm ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " /:");

		monthTime = new long[12];


        N = Integer.parseInt(st.nextToken());
        int DDD = Integer.parseInt(st.nextToken());
		int hh = Integer.parseInt(st.nextToken());
		int mm = Integer.parseInt(st.nextToken());
		// 하루는 1440분, 한 시간은 60분으로 대여 기간을 분 단위로 계산해준다.
        rentalMTime = (DDD * 1440) + (hh * 60) + mm; // 대여 기간
		
        F = Integer.parseInt(st.nextToken());

        // 키 : 이름, 값 : 날짜 및 시간, 부품정보
        hm = new HashMap<>();
        resultHm = new HashMap<>(); // 결과 저장

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), "- :");
			st.nextToken();
            int month = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			int hour = Integer.parseInt(st.nextToken());
			int minute = Integer.parseInt(st.nextToken());
            // 날짜 및 시간 정보
            long nowTime = getMonthTime(month - 1) + (day * 1440) + (hour * 60) + minute;

            String nowPart = st.nextToken(); // 부품 정보
            String nowUser = st.nextToken(); // 이름
            HashMap<String, Long> listInfo ;
            if(hm.containsKey(nowUser)){ // 해당 유저가 있을 때
                listInfo = hm.get(nowUser); // 현재 유저가 빌린 부품목록

                if(listInfo.containsKey(nowPart)){ // 해당 유저의 대여기록을 검색
                    long startTime = listInfo.get(nowPart);
                    // 같은 부품이라면 반납

                    // 요금계산 후 해시맵에서 삭제
                    long feeTime = calFeeTime(startTime, nowTime); //빌린 시간 계산
                    long nowFee = calFee(feeTime - rentalMTime); // 요금 계산
                    
                    // 결과값에 유저 추가
                    if(nowFee != 0 ) addResult(nowUser, nowFee);

                    // 해시맵에서 현재 부품만 !!! 제거
                    listInfo.remove(nowPart);
                }else{ // 다른 부품이라면 있던 내역 + 현재 부품으로 처리
                    listInfo.put(nowPart, nowTime);
                }

            }else{ // 처음 빌리므로 대여
                listInfo = new HashMap<>();
                listInfo.put(nowPart, nowTime);
            }
            hm.put(nowUser, listInfo);
        }

        // 출력부분
        StringBuilder sb = new StringBuilder();
        if(resultHm.size() == 0 ) sb.append(-1);
        else{
            List<String> names = new ArrayList<>(resultHm.keySet());
            Collections.sort(names);

            // 결과 출력
            for (String userName : names){
                sb.append(userName + " " + resultHm.get(userName)+"\n");
            }
            
        }
        System.out.println(sb.toString());
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    // 대여기간을 분으로 변환
    public static long calRentalTime(){
        // 대여기간 split DDD/hh:mm 일/시간/분
         String[] rentalDay = L.split("/"); // [0] : 날짜, 
         String[] times = rentalDay[1].split(":"); // [1] : 시간/분 (string)
         // 분 + 시간 + 날짜
         rentalMTime = stoi(times[1]) + (stoi(times[0])*60) + (stoi(rentalDay[0])*24*60); 
         return rentalMTime ;
    }

    // 반납한 시간 - 대여한 시간
    public static long calFeeTime(long startTime , long endTime){
        return endTime - startTime;
    }

    // 계산한 시간 - 대여기간 으로 요금 계산
    public static long calFee(long rTime){
        if(rTime <= 0 ) return 0 ; // 대여기간 뺀 값이 0 보다 작거나 같다면 요금 제로
        
        // 대여기간 넘길 경우 1분당 fee 
        return  F * rTime  ;
    }

    public static void addResult(String nowUser, long nowFee){
        if(resultHm.containsKey(nowUser)){ // 현재 유저가  결과값에 있다면 있던값에++
            resultHm.put(nowUser, resultHm.get(nowUser) + nowFee);
        }else{ // 없다면 --
            resultHm.put(nowUser, nowFee);
        }
    }
}
