package com.waterDrop.usercenter.model

/**
 * 作者：Nixon
 * date：2020/8/12.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
data class ArticleList(
    var curPage: String,
    var datas: List<Data>,
    var offset: String,
    var over: Boolean,
    var pageCount: String,
    var size: String,
    var total: String
)

data class Data(
    var apkLink: String,
    var audit: String,
    var author: String,
    var canEdit: Boolean,
    var chapterId: String,
    var chapterName: String,
    var collect: Boolean,
    var courseId: String,
    var desc: String,
    var descMd: String,
    var envelopePic: String,
    var fresh: Boolean,
    var id: String,
    var link: String,
    var niceDate: String,
    var niceShareDate: String,
    var origin: String,
    var prefix: String,
    var projectLink: String,
    var publishTime: Long,
    var realSuperChapterId: String,
    var selfVisible: String,
    var shareDate: Long,
    var shareUser: String,
    var superChapterId: String,
    var superChapterName: String,
    var tags: List<Tag>,
    var title: String,
    var type: String,
    var userId: String,
    var visible: String,
    var zan: String
)

data class Tag(
    var name: String,
    var url: String
)