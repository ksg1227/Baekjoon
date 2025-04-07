import java.io.*;
import java.util.*;

public class Main {


    // 진실을 아는 사람이 포함된 파티는 거짓을 말할 수 없음
    // 진실을 몰라도, 진실을 아는 사람과 같은 파티에 속해있는 사람은 진실을 안다고 간주해도 됨. 왜냐면 이 사람들한테 거짓말을 하면 진실된 사람이 있는 데에서 진실을 들어서 거짓말이라고 판단할테니까

    // 거짓말 할 수 있는 파티 개수 추적용
    static boolean[] canLie;

    // 진실을 아는 사람들
    static boolean[] knowLie;

    static int[] knowLiePerson;

    // 파티에 참여한 사람들
    static List<Integer>[] partyMember;

    // 각각의 유저가 속한 파티
    static List<Integer>[] participantParty;

    static int N;
    static int M;

    static int result = 0;

    // 각 유저가 어떤 파티에 속해있는지를 알아야하네.
    // 진실을 아는 유저를 찾으면, 해당 유저가 속한 파티에 참여한 나머지 유저들을 찾고,
    // 나머지 유저들이 참여한 파티도 다 똑같은 과정을 거쳐야함

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        canLie = new boolean[M + 1];
        knowLie = new boolean[N + 1];
        partyMember = new List[M + 1];
        participantParty = new List[N + 1];


        for (int i = 1; i <= M; i++) {
            partyMember[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            participantParty[i] = new ArrayList<>();
        }
        Arrays.fill(canLie, true);

        st = new StringTokenizer(br.readLine());

        int knowLieCount = Integer.parseInt(st.nextToken());
        knowLiePerson = new int[knowLieCount];

        for (int i = 0; i < knowLieCount; i++) {
            int index = Integer.parseInt(st.nextToken());
            knowLiePerson[i] = index;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int personNum = Integer.parseInt(st.nextToken());

            // 만약 파티 참여자중에 진실을 아는 사람이 있다면, 그 파티에 속한 모든 참여자들도 진실을 안다고 간주해도 됨
            for (int j = 0; j < personNum; j++) {
                int participant = Integer.parseInt(st.nextToken());

                partyMember[i].add(participant);
                participantParty[participant].add(i);
            }
        }

        for (int i = 0; i < knowLieCount; i++) {
            // 진실을 아는 사람 번호
            int index = knowLiePerson[i];

            dfs(index);
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < partyMember[i].size(); j++) {
                int person = partyMember[i].get(j);

                if (knowLie[person]) {
                    canLie[i] = false;
                    break;
                }
            }
        }

        for(int i=1;i<=M;i++) {
            if(canLie[i]){
                result++;
            }
        }

        System.out.println(result);
    }

    static void dfs(int knowLiePersonIndex) {

        if (knowLie[knowLiePersonIndex]) {
            return;
        }

        knowLie[knowLiePersonIndex] = true;

        // 특정 진실을 아는 사람이 속한 파티를 다 가져옴
        for (int i = 0; i < participantParty[knowLiePersonIndex].size(); i++) {

            // 각각의 파티들
            int partyNum = participantParty[knowLiePersonIndex].get(i);

            // 해당 파티에 속한 다른 유저들도 진실을 안다고 판정
            for (int j = 0; j < partyMember[partyNum].size(); j++) {
                int personNum = partyMember[partyNum].get(j);

                if (personNum != knowLiePersonIndex) {
                    dfs(personNum);
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
