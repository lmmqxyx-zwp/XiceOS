/**
 * 替换
 *
 * @param a 源数据
 * @param b 键
 * @param c 值
 * @return {string}
 * @constructor
 */
function X_BLOG_REPLACE(a, b, c) {
    var d = a.split('&');
    var f = '';
    for (var i = 0; i < d.length; i++) {
        var e = d[i];
        if (e.indexOf(b + '=') != -1) {
            e = b + '=' + c;
        }
        f += e + '&';
    }
    if (f.length != 0) {
        f = f.substring(0, f.length);
    }

    return f;
}

/**
 * 获取
 *
 * @param a 源数据
 * @param b 键
 * @return {string}
 * @constructor
 */
function X_BLOG_FIND(a, b) {
    var d = a.split('&');
    for (var i = 0; i < d.length; i++) {
        var e = d[i];
        if (e.indexOf(b + '=') != -1) {
            return e.split('=')[1];
        }
    }

    return '';
}