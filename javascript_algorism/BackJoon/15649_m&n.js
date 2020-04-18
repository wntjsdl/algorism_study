// https://www.acmicpc.net/problem/15649var fs = require("fs")

// const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().split(' ');
// const m = Number(input[0]);
// const n = Number(input[1]);

const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (answer) {
    input = answer.split(' ').map((el) => parseInt(el));
    const m = input[0];
    const n = input[1];
    solution(m, n);
})

function solution(m, n) {
    const answerArr = [];
    const arr = [];
    for (let i = 1; i <= m; i++) {
        arr.push(i);
    }
    const tempArr = getPermutations(arr, n);
    for (let i = 0; i < tempArr.length; i++) {
        const tempArr2 = permute(tempArr[i]);
        for (let j = 0; j < tempArr2.length; j++) {
            answerArr.push(tempArr2[j].join(' '));
        }
    }
    answerArr.sort();
    for (let i = 0; i < answerArr.length; i++) {
        console.log(answerArr[i]);
    }
}

function getPermutations(array, size) {
    function p(t, i) {
        if (t.length === size) {
            result.push(t);
            return;
        }
        if (i + 1 > array.length) {
            return;
        }
        p(t.concat(array[i]), i + 1);
        p(t, i + 1);
    }
    var result = [];
    p([], 0);
    return result;
}

function permute(permutation) {
    var length = permutation.length,
        result = [permutation.slice()],
        c = new Array(length).fill(0),
        i = 1, k, p;

    while (i < length) {
        if (c[i] < i) {
            k = i % 2 && c[i];
            p = permutation[i];
            permutation[i] = permutation[k];
            permutation[k] = p;
            ++c[i];
            i = 1;
            result.push(permutation.slice());
        } else {
            c[i] = 0;
            ++i;
        }
    }
    return result;
}
