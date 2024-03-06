#include <iostream>

using namespace std;

void cycle(int num1, int num2, int *arr1, int *arr2, int *pcount);

int main() {
    int arr1[2];   //주어진 수로 만들 수 있는 경우
    int arr2[2];   //새로운 수

    int num = 0;  //초기 숫자
    int count = 0;
    int *pcount = &count;
    cin >> num;

    cycle(num, num, arr1, arr2, pcount);
    cout << count << endl;
}

void cycle(int num1, int num2, int *arr1, int *arr2, int *pcount) {

    int sum = 0;

    if (num2 < 10) {   //주어진 수가 10보다 작을 때
        arr1[0] = num2;
        arr1[1] = 0;
        sum = arr1[0] + arr1[1];
        arr2[0] = arr1[0];
        arr2[1] = sum % 10;
    } else {         //주어진 수가 10보다 클 때
        arr1[0] = num2 / 10;
        arr1[1] = num2 % 10;
        sum = arr1[0] + arr1[1];
        arr2[0] = arr1[1];
        arr2[1] = sum % 10;
    }

    num2 = arr2[0] * 10 + arr2[1];

    if (num1 == num2) {
        *pcount = *pcount + 1;
        return;
    } else {
        *pcount = *pcount + 1;
        cycle(num1,num2, arr1, arr2, pcount);
    }
}
