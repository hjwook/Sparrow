let getGCD = (num1, num2) => {
    let gcd = 1;

    for (let i = 2; i <= Math.min(num1, num2); i++) {
        if (num1 % i === 0 && num2 % i === 0) {
            gcd = i;
        }
    }

    return gcd;
}
function solution(denum1, num1, denum2, num2) {
    var answer = [];

    var deno = num1 * num2;
    var nume = denum1 * num2 + denum2 * num1;

    var gcd = getGCD(deno, nume);


    answer[0] = nume / gcd;
    answer[1] = deno / gcd;

    return answer;
}