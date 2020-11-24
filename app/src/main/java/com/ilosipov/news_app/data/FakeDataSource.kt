package com.ilosipov.news_app.data

import android.util.Log
import java.util.*

/**
 * Class FakeDataSource - this fake data source class is a testing class that will be used to generate some random data
 * @author Ilya Osipov (mailto:il.osipov.gm@mail.com)
 * @since 24.11.2020
 * @version $Id$
 */
/**
 * this class provides a List of news item
 * this is how the news item data looks like in JSON format:
 * {
 * "id" : 0,
 * "title" : "Design A Simple UI Screen in Flare",
 * "itemType" : 1,
 * "newsContent" : "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book. It usually begins with: The purpose of lorem ipsum is to create a natural looking block of text (sentence, paragraph, page, etc.) that doesn't distract from the layout. A practice not without controversy, laying out pages with meaningless filler text can be very useful when the focus is meant to be on design, not content.",
 * "newsImg" : "https://2.bp.blogspot.com/-ddZ2Tt8EOeo/XxtDIkHWgDI/AAAAAAAAAn0/vG13Vw5zoXU5fy_sHQ_7lW6PQz1UEXocACK4BGAYYCw/s1600/news5.PNG",
 * "userImg" : "https://2.bp.blogspot.com/-6EcFUPmzExo/XxtD9BbEO4I/AAAAAAAAAo0/n-AxAZrAVLQBbzjcKhkIOHtSLixVUz0lgCK4BGAYYCw/s400/user3.png",
 * "username" : "Invision Studio",
 * "date" : "03/08/2020",
 * "backgroundBg" : "RED"
 * }
 */
class FakeDataSource {
    private var random: Random = Random()

    /** News item data format
     *
     * this.id = id;
     * this.title = title;
     * this.username = username;
     * this.newsImg = newsImg;
     * this.userImg = userImg;
     * this.newsContent = newsContent;
     * this.bgColor = bgColor;
     * this.date = date;
     * this.viewType = viewType;
     */
    val fakeListNews: List<NewsItem>
        get() {
            val data: MutableList<NewsItem> = ArrayList()
            for (index in 0..29) {
                val item = NewsItem(index,
                        randomNewsTitle,
                        randomUsername,
                        randomNewsImage,
                        randomUserImage,
                        randomContent,
                        randomBgColor,
                        null,
                        generateViewType(index))
                data.add(item)
            }
            return data
        }

    // generate a static list news Items
    val fakeStaticListNews: List<NewsItem>
        get() {
            val data: MutableList<NewsItem> = ArrayList()
            return data.apply {
                add(NewsItem(0, TXT_TITLE_01, TXT_NAME_01, IMG_NEWS_01, IMG_USER_01,
                        randomContent, lstColors[0], Date(), 1))
                add(NewsItem(1, TXT_TITLE_02, TXT_NAME_02, IMG_NEWS_02, IMG_USER_02,
                        randomContent, lstColors[2], Date(), 0))
                add(NewsItem(2, TXT_TITLE_03, TXT_NAME_03, IMG_NEWS_03, IMG_USER_03,
                        randomContent, lstColors[0], Date(), 0))
                add(NewsItem(3, TXT_TITLE_04, TXT_NAME_04, IMG_NEWS_02, IMG_USER_04,
                        randomContent, lstColors[2], Date(), 1))
                add(NewsItem(4, TXT_TITLE_05, TXT_NAME_01, IMG_NEWS_03, IMG_USER_05,
                        randomContent, lstColors[1], Date(), 1))
                add(NewsItem(5, TXT_TITLE_03, TXT_NAME_01, IMG_NEWS_02, IMG_USER_03,
                        randomContent, lstColors[1], Date(), 0))
                add(NewsItem(6, TXT_TITLE_01, TXT_NAME_01, IMG_NEWS_01, IMG_USER_01,
                        randomContent, lstColors[2], Date(), 0))
                add(NewsItem(7, TXT_TITLE_01, TXT_NAME_01, IMG_NEWS_01, IMG_USER_01,
                        randomContent, lstColors[3], Date(), 1))
                add(NewsItem(8, TXT_TITLE_01, TXT_NAME_01, IMG_NEWS_10, IMG_USER_01,
                        randomContent, lstColors[2], Date(), 1))
                add(NewsItem(9, TXT_TITLE_01, TXT_NAME_01, IMG_NEWS_08, IMG_USER_01,
                        randomContent, lstColors[1], Date(), 0))
            }
        }

    // generate an updated static news list
    val fakeUpdatedStaticListNews: List<NewsItem>
        get() {
            val data: MutableList<NewsItem> = ArrayList()
            return data.apply {
                add(NewsItem(-4, TXT_TITLE_01, TXT_NAME_01, IMG_NEWS_10, IMG_USER_01,
                        randomContent, lstColors[0], Date(), 1))
                add(NewsItem(-3, TXT_TITLE_02, TXT_NAME_02, IMG_NEWS_02, IMG_USER_02,
                        randomContent, lstColors[2], Date(), 0))
                add(NewsItem(-2, TXT_TITLE_03, TXT_NAME_03, IMG_NEWS_07, IMG_USER_03,
                        randomContent, lstColors[0], Date(), 0))
                add(NewsItem(-1, TXT_TITLE_04, TXT_NAME_04, IMG_NEWS_09, IMG_USER_04,
                        randomContent, lstColors[2], Date(), 1))
                add(NewsItem(0, TXT_TITLE_01, TXT_NAME_01, IMG_NEWS_01, IMG_USER_01,
                        randomContent, lstColors[0], Date(), 1))
                add(NewsItem(1, TXT_TITLE_02, TXT_NAME_02, IMG_NEWS_02, IMG_USER_02,
                        randomContent, lstColors[2], Date(), 0))
                add(NewsItem(2, TXT_TITLE_03, TXT_NAME_03, IMG_NEWS_03, IMG_USER_03,
                        randomContent, lstColors[0], Date(), 0))
                add(NewsItem(3, TXT_TITLE_04, TXT_NAME_04, IMG_NEWS_02, IMG_USER_04,
                        randomContent, lstColors[2], Date(), 1))
                add(NewsItem(4, TXT_TITLE_05, TXT_NAME_01, IMG_NEWS_03, IMG_USER_05,
                        randomContent, lstColors[1], Date(), 1))
                add(NewsItem(5, TXT_TITLE_03, TXT_NAME_01, IMG_NEWS_02, IMG_USER_03,
                        randomContent, lstColors[1], Date(), 0))
                add(NewsItem(6, TXT_TITLE_01, TXT_NAME_01, IMG_NEWS_01, IMG_USER_01,
                        randomContent, lstColors[2], Date(), 0))
                add(NewsItem(7, TXT_TITLE_01, TXT_NAME_01, IMG_NEWS_01, IMG_USER_01,
                        randomContent, lstColors[3], Date(), 1))
                add(NewsItem(8, TXT_TITLE_01, TXT_NAME_01, IMG_NEWS_10, IMG_USER_01,
                        randomContent, lstColors[2], Date(), 1))
                add(NewsItem(9, TXT_TITLE_01, TXT_NAME_01, IMG_NEWS_08, IMG_USER_01,
                        randomContent, lstColors[1], Date(), 0))
            }
        }

    private fun initListNewsImages() {
        listNewsImage.apply {
            add(IMG_NEWS_01)
            add(IMG_NEWS_02)
            add(IMG_NEWS_03)
            add(IMG_NEWS_04)
            add(IMG_NEWS_05)
            add(IMG_NEWS_06)
            add(IMG_NEWS_07)
            add(IMG_NEWS_08)
            add(IMG_NEWS_09)
            add(IMG_NEWS_10)
        }
    }

    private fun initListUserImages() {
        listUserImage.apply {
            add(IMG_USER_01)
            add(IMG_USER_02)
            add(IMG_USER_03)
            add(IMG_USER_04)
            add(IMG_USER_05)
        }
    }

    private fun initListNewsTitle() {
        listNewsTitles.apply {
            add(TXT_TITLE_01)
            add(TXT_TITLE_02)
            add(TXT_TITLE_03)
            add(TXT_TITLE_04)
            add(TXT_TITLE_05)
        }
    }

    fun initListUsername() {
        listUserNames.apply {
            add(TXT_NAME_01)
            add(TXT_NAME_02)
            add(TXT_NAME_03)
            add(TXT_NAME_04)
        }
    }

    var listNewsImage: MutableList<String> = ArrayList()
    var listUserImage: MutableList<String> = ArrayList()
    var listNewsTitles: MutableList<String> = ArrayList()
    var listUserNames: MutableList<String> = ArrayList()

    /**
     * this method generate a random news item
     */
    fun generateRandomNewsItem(): NewsItem {
        return NewsItem(-1, randomNewsTitle, randomUsername, randomNewsImage, randomUserImage, randomContent, randomBgColor, null, 0)
    }

    // generate a random string title
    private val randomNewsTitle: String
        get() {
            val index = random.nextInt(listNewsTitles.size)
            return listNewsTitles[index]
        }

    // generate a random news image url string
    private val randomNewsImage: String
        get() {
            val index = random.nextInt(listNewsImage.size)
            return listNewsImage[index]
        }

    // generate a random news image url string
    private val randomUserImage: String
        get() {
            val index = random.nextInt(listUserImage.size)
            return listUserImage[index]
        }

    // generate a random String Content
    private val randomUsername: String
        get() {
            val index = random.nextInt(listUserNames.size)
            return listUserNames[index]
        }

    // generate a random news background color
    private val randomBgColor: String
        get() {
            val index = random.nextInt(lstColors.size)
            return lstColors[index]
        }

    // generate random date
    private val randomDate: Date
        get() = Date()

    // generate a viewtype based on the index and the list size
    // this specify the view grid system of the format of the news system list
    private fun generateViewType(position: Int): Int {
        if (position == 0) {
            return 1
        } else if (position == 1) {
            return 0
        }
        if (position != 0) {
            val ir = position / 2 + 1
            Log.e("TAG", "generateViewType: $ir")
            return if (ir % 2 == 0) {
                if (position % 2 == 0) {
                    0
                } else 1
            } else {
                if (position % 2 == 0) {
                    1
                } else 0
            }
        }
        return 0
    }

    companion object {
        // news images url's for testing
        const val IMG_NEWS_01 = "https://2.bp.blogspot.com/-ddZ2Tt8EOeo/XxtDIkHWgDI/AAAAAAAAAn0/vG13Vw5zoXU5fy_sHQ_7lW6PQz1UEXocACK4BGAYYCw/s1600/news5.PNG"
        const val IMG_NEWS_02 = "https://4.bp.blogspot.com/-4QOyU3Q5D8c/XxtDIQ_pLmI/AAAAAAAAAns/FbocmpIje1YFxfqG5Ajln7OeJ8dX6h3wQCK4BGAYYCw/s1600/news3.PNG"
        const val IMG_NEWS_03 = "https://1.bp.blogspot.com/-dpcd0TBJ5xk/XxtDboRBeYI/AAAAAAAAAoE/CdWFJq1k8GsGgAwGTLGJd6ToCwvtO9OtwCK4BGAYYCw/s1600/newsimg2.PNG"
        const val IMG_NEWS_04 = "https://3.bp.blogspot.com/-Ele_lJ7t2Fg/XxtD9BfVm8I/AAAAAAAAAow/m8fpgF7Ocmcfs2rJ6nGP-Dsms5X5PQdwwCK4BGAYYCw/s1600/newsimg.png"
        const val IMG_NEWS_05 = "https://2.bp.blogspot.com/-4eQzZxP2ubw/Xx4XnCFRANI/AAAAAAAAAps/Xwugw45_OD8rfOw_CPgbJ6455IiAspF8wCK4BGAYYCw/s1600/illust2.jpg"
        const val IMG_NEWS_06 = "http://4.bp.blogspot.com/-aisXccEBqJY/Xx37Zdf7wMI/AAAAAAAAApg/8mbSFn0JvrIdIIRJrxoaU7GH0wsBOgCsACK4BGAYYCw/s640/illustration.jpg"
        const val IMG_NEWS_07 = "https://cdn.dribbble.com/users/1663335/screenshots/13906863/media/f82fca5285ba7260e7408cff9edb3fa7.jpg"
        const val IMG_NEWS_08 = "http://4.bp.blogspot.com/-aisXccEBqJY/Xx37Zdf7wMI/AAAAAAAAApg/8mbSFn0JvrIdIIRJrxoaU7GH0wsBOgCsACK4BGAYYCw/s640/illustration.jpg"
        const val IMG_NEWS_09 = "https://cdn.dribbble.com/users/2400016/screenshots/13897147/media/2e54a3ade13ebb2611c999e4178c133f.png"
        const val IMG_NEWS_10 = "https://cdn.dribbble.com/users/2400016/screenshots/11466370/image.png"

        // user images for testing
        const val IMG_USER_01 = "https://2.bp.blogspot.com/-6EcFUPmzExo/XxtD9BbEO4I/AAAAAAAAAo0/n-AxAZrAVLQBbzjcKhkIOHtSLixVUz0lgCK4BGAYYCw/s400/user3.png"
        const val IMG_USER_02 = "https://2.bp.blogspot.com/-R0rfeBv6PbA/XxtD75IBizI/AAAAAAAAAoU/xgUu9IuGwVcwpnihSXMNSZ9YhiNrIpTuwCK4BGAYYCw/s400/user4.png"
        const val IMG_USER_03 = "https://1.bp.blogspot.com/-7cV7-_0mgv8/XxtD9IRzJBI/AAAAAAAAAo4/WaMt1T9cfXgn1qGmnYa3oWGUEW2IQUbmACK4BGAYYCw/s400/user2.png"
        const val IMG_USER_04 = "https://cdn.dribbble.com/users/2400016/avatars/normal/401c4be556cfced8004233dad4afdd98.jpg?1592492657"
        const val IMG_USER_05 = "https://1.bp.blogspot.com/-crUZwpqquAo/XxtD7_lwqEI/AAAAAAAAAoY/TbRYnR82uk8LXrQpx-tsBA4-KyFISSFUgCK4BGAYYCw/s400/user.png"

        // user titles for testing
        const val TXT_TITLE_01 = "Stack Overflow - Where Developers Learn, Share, and Build"
        const val TXT_TITLE_02 = "Book About Stars"
        const val TXT_TITLE_03 = "Design A Simple UI Screen in Flare"
        const val TXT_TITLE_04 = "Naija-based designer making stuff with Studio"
        const val TXT_TITLE_05 = "How To Write Better Resume"

        // user names for testing
        const val TXT_NAME_01 = "Jona Dinges"
        const val TXT_NAME_02 = "Invision Studio"
        const val TXT_NAME_03 = "Benoit Drigny"
        const val TXT_NAME_04 = "Ada Vishneva"

        // generate a random String Content
        // News content for testing
        private const val randomContent = "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book. It usually begins with: The purpose of lorem ipsum is to create a natural looking block of text (sentence, paragraph, page, etc.) that doesn't distract from the layout. A practice not without controversy, laying out pages with meaningless filler text can be very useful when the focus is meant to be on design, not content."

        // news background colors
        val lstColors = arrayOf("RED", "YELLOW", "BLACK", "PURPLE")
    }

    init {
        initListNewsImages()
        initListUserImages()
        initListNewsTitle()
        initListUsername()
    }
}