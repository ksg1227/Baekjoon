import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		long N = Integer.parseInt(input);
		long sum = 0;

		for(long i=1;i<=N;i++) {
			sum += (N - i + 1) * (N - i + 1);
		}

		System.out.println(sum);
	}
}