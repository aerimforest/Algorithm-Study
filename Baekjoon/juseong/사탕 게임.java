import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static String[][] grid;        // 봄보니 맵
	private static int maxCount = 0;    // 연속된 최대 길이
	private static int row_column_count = 0;    // 행과 열의 길이
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));    // 입력받기용

	public static void main(String[] args) throws IOException {
		// 데이터 입력받아서 2차원 배열의 값 초기화
		row_column_count = Integer.valueOf(reader.readLine());
		grid = new String[row_column_count][row_column_count];
		initGrid(row_column_count);

		// 현재 보드에 있는 사탕 중 같은색으로 이루어진 가장 긴 연속부분 구하기
		countMaxContinuesLength();
		// 사탕을 교환하고 가장 긴 연속부분 구하기
		swapAndCount();
		// 출력
		System.out.println(maxCount);

	}

	/**
	 * 행 또는 열 기준으로 인접한 사탕의 색이 다르면 교환하고,
	 * 가장 긴 연속부분의 길이를 구한다.
	 */
	private static void swapAndCount() {
		// 행 기준으로 비교
		for (int i = 0; i < row_column_count; i++) {
			for (int j = 0; j < row_column_count - 1; j++) {
				// 우측에 인접한 사탕의 색이 다르면
				if (!grid[i][j].equals(grid[i][j + 1])) {
					// 사탕의 위치를 저장하고 교환
					LocationVo locationVoFirst = new LocationVo(i, j);
					LocationVo locationVoSecond = new LocationVo(i, j + 1);
					swap(locationVoFirst, locationVoSecond);
					// 사탕을 교환했으니, 가장 긴 연속부분 길이 구하기
					countMaxContinuesLength();
					// 앞에서 교환환 사탕 다시 원위치
					// 원 위치 하는 이유는 2차원 배열 한개로 계산을 쭉 이어나가기 위해서임
					swap(locationVoFirst, locationVoSecond);
				}
			}
		}

		// 열을 기준으로 비교
		for (int i = 0; i < row_column_count; i++) {
			for (int j = 0; j < row_column_count - 1; j++) {
				if (!grid[j][i].equals(grid[j + 1][i])) {
					LocationVo locationVoFirst = new LocationVo(j, i);
					LocationVo locationVoSecond = new LocationVo(j + 1, i);
					swap(locationVoFirst, locationVoSecond);
					countMaxContinuesLength();
					swap(locationVoFirst, locationVoSecond);
				}
			}
		}
	}

	/**
	 * 같은 색으로 이루어져 있는 가장 긴 연속부분 길이 구하기
	 */
	private static void countMaxContinuesLength() {
		// 행 기준으로 구하기
		for (int i = 0; i < row_column_count; i++) {
			int tempMaxCount = 1;
			for (int j = 0; j < row_column_count - 1; j++) {
				// 옆에 있는 사탕이 같은 색이라면
				if (grid[i][j].equals(grid[i][j + 1])) {
					// 길이 1증가
					tempMaxCount++;
					// 마지막 비교라면
					if (isLastCompareIndex(j)) {
						// 현재까지 구한 길이로 최대길이 갱신 시도
						updateMaxCount(tempMaxCount);
					}
					continue;
				}
				// 옆에 있는 사탕이 같은색이 아니면
				// 현재까지 구한 길이로 최대길이 갱신 시도
				updateMaxCount(tempMaxCount);
				// 연속이 끊겼으므로 길이값 초기화
				tempMaxCount = 1;
			}
		}

		for (int i = 0; i < row_column_count; i++) {
			int tempMaxCount = 1;
			for (int j = 0; j < row_column_count - 1; j++) {
				if (grid[j][i].equals(grid[j + 1][i])) {
					tempMaxCount++;
					if (isLastCompareIndex(j)) {
						updateMaxCount(tempMaxCount);
					}
					continue;
				}
				updateMaxCount(tempMaxCount);
				tempMaxCount = 1;
			}
		}
	}

	private static boolean isLastCompareIndex(int index) {
		return index == row_column_count - 2;
	}

	private static void updateMaxCount(int tempMaxCount) {
		maxCount = Math.max(tempMaxCount, maxCount);
	}

	private static void swap(LocationVo first, LocationVo second) {
		String temp = grid[first.rowIndex][first.columnIndex];
		grid[first.rowIndex][first.columnIndex] = grid[second.rowIndex][second.columnIndex];
		grid[second.rowIndex][second.columnIndex] = temp;
	}

	private static void initGrid(int row_column_count) throws IOException {
		for (int i = 0; i < row_column_count; i++) {
			String[] candies = reader.readLine().split("");
			for (int j = 0; j < candies.length; j++) {
				grid[i][j] = candies[j];
			}
		}
	}

	private static class LocationVo {
		int rowIndex;        // 행 위치
		int columnIndex;    // 열 위치

		public LocationVo(int rowIndex, int columnIndex) {
			this.rowIndex = rowIndex;
			this.columnIndex = columnIndex;
		}
	}
}
