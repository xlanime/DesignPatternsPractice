package com.gupao.learn.design.model.prototype.deep;

/**
 * Description:原型模式-深度复制
 *   1、深复制和浅复制。
 *      简单理解，深复制就是完全复制一个新的对象出来，修改新对象的属性与原对象无关。
 *      而浅复制就只是复制了一个新的对象，属性还是原来的对象的，修改后影响原来的对象。
 *   2、原型模式：
 *      简单讲，原型模式就是有一个原型，将它复制为新的对象，实现业务分离。
 *      例如DTO和VO，从数据库查出DTO后，将其属性赋值给VO，再传给View使用，这就是原型模式的实现。
 *
 * @author 轩辚
 * @date 2019/3/5 0:34
 */
public class DeepClone {

}
