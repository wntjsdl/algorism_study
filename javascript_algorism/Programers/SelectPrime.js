function solution(numbers) {

    var answer = 0;
    var primeArr = [];
    var primeArr2 = [];
    for(let i = 0; i < numbers.length; i++){
        primeArr.push(numbers[i]);
        primeArr2.push(numbers[i]);
    }
    // console.log(primeArr);
    for(let i = 2; i <= numbers.length; i++){
        var tempArr = getPermutations(primeArr, i);
        // console.log('tempArr >> ', tempArr);
        for(let j = 0; j < tempArr.length; j++){
            var tempArr2 = permute(tempArr[j]);
            // console.log('tempArr2 >> ', tempArr2);
            for(let k = 0; k < tempArr2.length; k++){
                let tempNum = tempArr2[k].join('');
                // console.log('join >> ', tempNum);
                primeArr2.push(tempNum);
            }
        }
    }
    for(let i = 0; i < primeArr2.length; i++){
        primeArr2[i] = parseInt(primeArr2[i]);
    }
    const set = new Set(primeArr2);
    for ( let item of set ) {
        if(!chkPrime(item)){
            set.delete(item);
        }
    }
    // console.log(JSON.stringify([...set]));
    answer = set.size;
    console.log('numbers >> ', numbers);
    console.log('answer >> ', answer);
    return answer;
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

function chkPrime(num) {
    if (num == 1 || num == 0)
        return false;
    for (var i=2; i<=num/2; i++) {
        var result = num % i;
        if (result == 0) {
            return false;
        }
    }
    return true;
};

solution("17");
solution("011");