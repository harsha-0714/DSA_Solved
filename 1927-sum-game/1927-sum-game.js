/**
 * @param {string} num
 * @return {boolean}
 */
var sumGame = function(num) {
    const n = num.length;
    let diff = 0;
    let cnt = 0;
    for(let i = 0;i<n;i++){
        const first = i < n/2;
        if(num[i] === '?'){
            cnt += first ? 1 : -1;
        }else{
            const digit = Number(num[i]);
            diff += first ? digit : -digit;
        }
    }
    return diff * 2 != -9 * cnt;
};