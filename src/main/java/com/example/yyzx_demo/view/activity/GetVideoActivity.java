package com.example.yyzx_demo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yyzx_demo.R;
import com.example.yyzx_demo.service.model.entity.GetVideoEntity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GetVideoActivity extends AppCompatActivity {

    @BindView(R.id.getvideo_back)
    ImageView back;
    @BindView(R.id.getvideo_toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.getvideo_toolbar)
    Toolbar toolbar;
    @BindView(R.id.getvideo_frame)
    RelativeLayout frame;
    @BindView(R.id.getvideo_share_pic)
    SimpleDraweeView sharePic;
    @BindView(R.id.getvideo_tab)
    TabLayout tabLayout;
    @BindView(R.id.getvideo_share_url)
    SimpleDraweeView shareUrl;
    @BindView(R.id.getvideo_shikan)
    TextView shiKan;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_video);
        bind = ButterKnife.bind(this);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        String jsonString = getJsonString();
        Gson gson = new Gson();
        GetVideoEntity getVideoEntity = gson.fromJson(jsonString, GetVideoEntity.class);
        GetVideoEntity.DataBean data = getVideoEntity.getData();

        toolbarTitle.setText(data.getChapterName());
        sharePic.setImageURI("http://ali-files.yooshow.com/2017/01/24/03f07dc9-407f-4157-a2e7-b76b2d51f80f.jpg");
        shareUrl.setImageURI("http://ali-files.yooshow.com/2019/07/18/13f108f4-0458-4c52-992a-2afe45f42f47.jpg");

        shiKan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VideoPlayerActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    private String getJsonString() {
        String s = "\n" +
                "{\n" +
                "  \"success\" : true,\n" +
                "  \"message\" : \"\",\n" +
                "  \"code\" : \"success\",\n" +
                "  \"data\" : {\n" +
                "    \"id\" : 1592,\n" +
                "    \"name\" : \"《沃尔法特小提琴练习曲60首》第1课\",\n" +
                "    \"url\" : \"yPb7v1LZHyET3i2oQbh8cSp+GlyRKN1KUMdv2w7SkP7Do0jYL3Otez8G5fA8ojW94iaOSB3a/YXHdOjLzLsQZD9B4cewJWL+HRg9JsxCJJ6fFykAZGfnjzs70k5pz878H276CfGb7F4FBOFSNgX/Pn5HYOBnDR0I6/2dk1l0r9mVwIOdeZKzNTCF1D8aItnFvY8HFrFAAnScW3fI1Z7Wcw==\",\n" +
                "    \"image\" : \"http://ali-files.yooshow.com/2019/07/18/13f108f4-0458-4c52-992a-2afe45f42f47.jpg\",\n" +
                "    \"teacherId\" : 52,\n" +
                "    \"videoType\" : 0,\n" +
                "    \"pauseOnSecond\" : 90,\n" +
                "    \"pause\" : 90,\n" +
                "    \"pauseText\" : \"\",\n" +
                "    \"summany\" : \"第一课给出了多种练习的弓法和变化，这是把一首练习曲所涵盖的技术完全吃透的关键。</div>\",\n" +
                "    \"videoPrice\" : 0.0,\n" +
                "    \"roomId\" : 0,\n" +
                "    \"totalSeconds\" : 949,\n" +
                "    \"packageId\" : 0,\n" +
                "    \"courseId\" : 398,\n" +
                "    \"courseName\" : \"《沃尔法特小提琴练习曲60首》\",\n" +
                "    \"courseType\" : 1,\n" +
                "    \"groupType\" : 0,\n" +
                "    \"courseIntroduce\" : \"该练习曲集共有练习曲60首。可分两部分：第一部分为前30首，是第一把位的练习；第二部分为后30首，是把位与换把练习。两个部分均在三个升降记号以内的调性进行。　总之，该练习曲集的基础训练内容是比较全面系统的，无论在调性、拍子、节奏、速度、力度、弓法、指法、还是把位与换把、双音、装饰音等方面，它都有一个全面的布局，由浅入深，从简到繁，主次有序、循序渐进，并且在每首练习曲之间既有所衔接又可独立，给教师教学提供了再创造和选择的可能。　实践证明，只要在教师正确的指导和家长耐心的辅导下，经过学生的认真努力，将会获得坚实的基础。</div>\",\n" +
                "    \"coursePrice\" : 600.0,\n" +
                "    \"courseVipPrice\" : 299.0,\n" +
                "    \"courseVipOpenType\" : 1,\n" +
                "    \"priceText\" : \"600元\",\n" +
                "    \"courseVipIcon\" : true,\n" +
                "    \"courseIsBuy\" : false,\n" +
                "    \"courseIsFavorites\" : false,\n" +
                "    \"chapterId\" : 2340,\n" +
                "    \"chapterName\" : \"《沃尔法特小提琴练习曲60首》第1课\",\n" +
                "    \"chapterPrice\" : 1.0,\n" +
                "    \"chapterIsBuy\" : false,\n" +
                "    \"teacherName\" : \"陈曦\",\n" +
                "    \"teacherTitle\" : \"中央音乐学院管弦系 副教授 小提琴演奏家\",\n" +
                "    \"teacherAvatar\" : \"http://ali-files.yooshow.com/2017/01/24/03f07dc9-407f-4157-a2e7-b76b2d51f80f.jpg\",\n" +
                "    \"teacherIntroduce\" : \"第一课给出了多种练习的弓法和变化，这是把一首练习曲所涵盖的技术完全吃透的关键。</div>\",\n" +
                "    \"chapters\" : [ {\n" +
                "      \"id\" : 2340,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第1课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 1,\n" +
                "      \"videoId\" : 1592,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1592,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"15:49\",\n" +
                "      \"totalSeconds\" : 949,\n" +
                "      \"studyProgress\" : \"未观看 / 15:49\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第1章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2341,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第2课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 2,\n" +
                "      \"videoId\" : 1593,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1593,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"14:56\",\n" +
                "      \"totalSeconds\" : 896,\n" +
                "      \"studyProgress\" : \"未观看 / 14:56\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第2章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2342,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第3课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 3,\n" +
                "      \"videoId\" : 1594,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1594,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"14:15\",\n" +
                "      \"totalSeconds\" : 855,\n" +
                "      \"studyProgress\" : \"未观看 / 14:15\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第3章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2343,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第4课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 4,\n" +
                "      \"videoId\" : 1595,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1595,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"11:57\",\n" +
                "      \"totalSeconds\" : 717,\n" +
                "      \"studyProgress\" : \"未观看 / 11:57\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第4章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2344,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第5课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 5,\n" +
                "      \"videoId\" : 1596,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1596,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"16:13\",\n" +
                "      \"totalSeconds\" : 973,\n" +
                "      \"studyProgress\" : \"未观看 / 16:13\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第5章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2345,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第6课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 6,\n" +
                "      \"videoId\" : 1623,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1623,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"14:00\",\n" +
                "      \"totalSeconds\" : 840,\n" +
                "      \"studyProgress\" : \"未观看 / 14:00\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第6章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2346,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第7课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 7,\n" +
                "      \"videoId\" : 1624,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1624,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"12:24\",\n" +
                "      \"totalSeconds\" : 744,\n" +
                "      \"studyProgress\" : \"未观看 / 12:24\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第7章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2347,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第8课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 8,\n" +
                "      \"videoId\" : 1625,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1625,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"10:32\",\n" +
                "      \"totalSeconds\" : 632,\n" +
                "      \"studyProgress\" : \"未观看 / 10:32\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第8章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2348,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第9课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 9,\n" +
                "      \"videoId\" : 1626,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1626,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"11:32\",\n" +
                "      \"totalSeconds\" : 692,\n" +
                "      \"studyProgress\" : \"未观看 / 11:32\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第9章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2349,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第10课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 10,\n" +
                "      \"videoId\" : 1627,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1627,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"10:27\",\n" +
                "      \"totalSeconds\" : 627,\n" +
                "      \"studyProgress\" : \"未观看 / 10:27\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第10章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2350,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第11课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 11,\n" +
                "      \"videoId\" : 1628,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1628,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"10:10\",\n" +
                "      \"totalSeconds\" : 610,\n" +
                "      \"studyProgress\" : \"未观看 / 10:10\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第11章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2351,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第12课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 12,\n" +
                "      \"videoId\" : 1629,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1629,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"12:57\",\n" +
                "      \"totalSeconds\" : 777,\n" +
                "      \"studyProgress\" : \"未观看 / 12:57\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第12章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2352,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第13课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 13,\n" +
                "      \"videoId\" : 1630,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1630,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"16:31\",\n" +
                "      \"totalSeconds\" : 991,\n" +
                "      \"studyProgress\" : \"未观看 / 16:31\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第13章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2353,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第14课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 14,\n" +
                "      \"videoId\" : 1632,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1632,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"14:44\",\n" +
                "      \"totalSeconds\" : 884,\n" +
                "      \"studyProgress\" : \"未观看 / 14:44\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第14章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2354,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第15课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 15,\n" +
                "      \"videoId\" : 1635,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1635,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"15:56\",\n" +
                "      \"totalSeconds\" : 956,\n" +
                "      \"studyProgress\" : \"未观看 / 15:56\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第15章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2355,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第16课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 16,\n" +
                "      \"videoId\" : 1636,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1636,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"10:21\",\n" +
                "      \"totalSeconds\" : 621,\n" +
                "      \"studyProgress\" : \"未观看 / 10:21\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第16章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2356,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第17课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 17,\n" +
                "      \"videoId\" : 1637,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1637,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"15:21\",\n" +
                "      \"totalSeconds\" : 921,\n" +
                "      \"studyProgress\" : \"未观看 / 15:21\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第17章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2357,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第18课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 18,\n" +
                "      \"videoId\" : 1639,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1639,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"14:45\",\n" +
                "      \"totalSeconds\" : 885,\n" +
                "      \"studyProgress\" : \"未观看 / 14:45\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第18章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2358,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第19课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 19,\n" +
                "      \"videoId\" : 1640,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1640,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"14:44\",\n" +
                "      \"totalSeconds\" : 884,\n" +
                "      \"studyProgress\" : \"未观看 / 14:44\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第19章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2359,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第20课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 20,\n" +
                "      \"videoId\" : 1642,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1642,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"13:01\",\n" +
                "      \"totalSeconds\" : 781,\n" +
                "      \"studyProgress\" : \"未观看 / 13:01\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第20章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2360,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第21课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 21,\n" +
                "      \"videoId\" : 1643,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1643,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"15:38\",\n" +
                "      \"totalSeconds\" : 938,\n" +
                "      \"studyProgress\" : \"未观看 / 15:38\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第21章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2361,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第22课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 22,\n" +
                "      \"videoId\" : 1644,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1644,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"13:41\",\n" +
                "      \"totalSeconds\" : 821,\n" +
                "      \"studyProgress\" : \"未观看 / 13:41\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第22章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2362,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第23课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 23,\n" +
                "      \"videoId\" : 1646,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1646,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"13:13\",\n" +
                "      \"totalSeconds\" : 793,\n" +
                "      \"studyProgress\" : \"未观看 / 13:13\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第23章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2363,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第24课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 24,\n" +
                "      \"videoId\" : 1647,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1647,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"14:37\",\n" +
                "      \"totalSeconds\" : 877,\n" +
                "      \"studyProgress\" : \"未观看 / 14:37\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第24章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2364,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第25课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 25,\n" +
                "      \"videoId\" : 1648,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1648,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"12:53\",\n" +
                "      \"totalSeconds\" : 773,\n" +
                "      \"studyProgress\" : \"未观看 / 12:53\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第25章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2365,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第26课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 26,\n" +
                "      \"videoId\" : 1650,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1650,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"17:36\",\n" +
                "      \"totalSeconds\" : 1056,\n" +
                "      \"studyProgress\" : \"未观看 / 17:36\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第26章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2366,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第27课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 27,\n" +
                "      \"videoId\" : 1652,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1652,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"19:04\",\n" +
                "      \"totalSeconds\" : 1144,\n" +
                "      \"studyProgress\" : \"未观看 / 19:04\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第27章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2367,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第28课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 28,\n" +
                "      \"videoId\" : 1653,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1653,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"12:40\",\n" +
                "      \"totalSeconds\" : 760,\n" +
                "      \"studyProgress\" : \"未观看 / 12:40\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第28章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2368,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第29课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 29,\n" +
                "      \"videoId\" : 1655,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1655,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"24:32\",\n" +
                "      \"totalSeconds\" : 1472,\n" +
                "      \"studyProgress\" : \"未观看 / 24:32\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第29章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2369,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第30课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 30,\n" +
                "      \"videoId\" : 1656,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1656,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"20:24\",\n" +
                "      \"totalSeconds\" : 1224,\n" +
                "      \"studyProgress\" : \"未观看 / 20:24\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第30章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2370,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第31课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 31,\n" +
                "      \"videoId\" : 1658,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1658,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"09:32\",\n" +
                "      \"totalSeconds\" : 572,\n" +
                "      \"studyProgress\" : \"未观看 / 09:32\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第31章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2371,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第32课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 32,\n" +
                "      \"videoId\" : 1659,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1659,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"19:10\",\n" +
                "      \"totalSeconds\" : 1150,\n" +
                "      \"studyProgress\" : \"未观看 / 19:10\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第32章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2372,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第33课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 33,\n" +
                "      \"videoId\" : 1661,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1661,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"18:15\",\n" +
                "      \"totalSeconds\" : 1095,\n" +
                "      \"studyProgress\" : \"未观看 / 18:15\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第33章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2373,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第34课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 34,\n" +
                "      \"videoId\" : 1662,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1662,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"13:43\",\n" +
                "      \"totalSeconds\" : 823,\n" +
                "      \"studyProgress\" : \"未观看 / 13:43\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第34章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2374,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第35课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 35,\n" +
                "      \"videoId\" : 1664,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1664,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"14:46\",\n" +
                "      \"totalSeconds\" : 886,\n" +
                "      \"studyProgress\" : \"未观看 / 14:46\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第35章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2375,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第36课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 36,\n" +
                "      \"videoId\" : 1666,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1666,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"15:24\",\n" +
                "      \"totalSeconds\" : 924,\n" +
                "      \"studyProgress\" : \"未观看 / 15:24\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第36章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2376,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第37课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 37,\n" +
                "      \"videoId\" : 1667,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 2.0,\n" +
                "      \"liveId\" : 1667,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"15:24\",\n" +
                "      \"totalSeconds\" : 924,\n" +
                "      \"studyProgress\" : \"未观看 / 15:24\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第37章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2377,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第38课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 38,\n" +
                "      \"videoId\" : 1669,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1669,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"13:07\",\n" +
                "      \"totalSeconds\" : 787,\n" +
                "      \"studyProgress\" : \"未观看 / 13:07\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第38章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2378,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第39课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 39,\n" +
                "      \"videoId\" : 1670,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1670,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"16:44\",\n" +
                "      \"totalSeconds\" : 1004,\n" +
                "      \"studyProgress\" : \"未观看 / 16:44\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第39章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2379,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第40课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 40,\n" +
                "      \"videoId\" : 1672,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1672,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"08:48\",\n" +
                "      \"totalSeconds\" : 528,\n" +
                "      \"studyProgress\" : \"未观看 / 08:48\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第40章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2380,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第41课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 41,\n" +
                "      \"videoId\" : 1677,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1677,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"15:53\",\n" +
                "      \"totalSeconds\" : 953,\n" +
                "      \"studyProgress\" : \"未观看 / 15:53\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第41章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2381,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第42课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 42,\n" +
                "      \"videoId\" : 1676,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 2.0,\n" +
                "      \"liveId\" : 1676,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"12:18\",\n" +
                "      \"totalSeconds\" : 738,\n" +
                "      \"studyProgress\" : \"未观看 / 12:18\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第42章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2382,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第43课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 43,\n" +
                "      \"videoId\" : 1675,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1675,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"11:52\",\n" +
                "      \"totalSeconds\" : 712,\n" +
                "      \"studyProgress\" : \"未观看 / 11:52\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第43章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2383,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第44课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 44,\n" +
                "      \"videoId\" : 1674,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1674,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"13:59\",\n" +
                "      \"totalSeconds\" : 839,\n" +
                "      \"studyProgress\" : \"未观看 / 13:59\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第44章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2384,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第45课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 45,\n" +
                "      \"videoId\" : 1673,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1673,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"14:16\",\n" +
                "      \"totalSeconds\" : 856,\n" +
                "      \"studyProgress\" : \"未观看 / 14:16\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第45章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2385,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第46课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 46,\n" +
                "      \"videoId\" : 1671,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1671,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"13:53\",\n" +
                "      \"totalSeconds\" : 833,\n" +
                "      \"studyProgress\" : \"未观看 / 13:53\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第46章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2386,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第47课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 47,\n" +
                "      \"videoId\" : 1668,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1668,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"09:53\",\n" +
                "      \"totalSeconds\" : 593,\n" +
                "      \"studyProgress\" : \"未观看 / 09:53\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第47章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2387,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第48课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 48,\n" +
                "      \"videoId\" : 1665,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1665,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"09:23\",\n" +
                "      \"totalSeconds\" : 563,\n" +
                "      \"studyProgress\" : \"未观看 / 09:23\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第48章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2388,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第49课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 49,\n" +
                "      \"videoId\" : 1663,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1663,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"12:23\",\n" +
                "      \"totalSeconds\" : 743,\n" +
                "      \"studyProgress\" : \"未观看 / 12:23\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第49章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2389,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第50课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 50,\n" +
                "      \"videoId\" : 1660,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1660,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"14:05\",\n" +
                "      \"totalSeconds\" : 845,\n" +
                "      \"studyProgress\" : \"未观看 / 14:05\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第50章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2390,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第51课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 51,\n" +
                "      \"videoId\" : 1657,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1657,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"16:49\",\n" +
                "      \"totalSeconds\" : 1009,\n" +
                "      \"studyProgress\" : \"未观看 / 16:49\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第51章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2391,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第52课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 52,\n" +
                "      \"videoId\" : 1654,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1654,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"17:21\",\n" +
                "      \"totalSeconds\" : 1041,\n" +
                "      \"studyProgress\" : \"未观看 / 17:21\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第52章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2392,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第53课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 53,\n" +
                "      \"videoId\" : 1651,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1651,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"10:16\",\n" +
                "      \"totalSeconds\" : 616,\n" +
                "      \"studyProgress\" : \"未观看 / 10:16\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第53章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2393,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第54课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 54,\n" +
                "      \"videoId\" : 1649,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1649,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"14:44\",\n" +
                "      \"totalSeconds\" : 884,\n" +
                "      \"studyProgress\" : \"未观看 / 14:44\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第54章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2394,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第55课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 55,\n" +
                "      \"videoId\" : 1645,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1645,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"13:33\",\n" +
                "      \"totalSeconds\" : 813,\n" +
                "      \"studyProgress\" : \"未观看 / 13:33\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第55章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2395,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第56课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 56,\n" +
                "      \"videoId\" : 1641,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 2.0,\n" +
                "      \"liveId\" : 1641,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"08:46\",\n" +
                "      \"totalSeconds\" : 526,\n" +
                "      \"studyProgress\" : \"未观看 / 08:46\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第56章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2396,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第57课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 57,\n" +
                "      \"videoId\" : 1638,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1638,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"10:03\",\n" +
                "      \"totalSeconds\" : 603,\n" +
                "      \"studyProgress\" : \"未观看 / 10:03\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第57章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2397,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第58课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 58,\n" +
                "      \"videoId\" : 1634,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1634,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"09:03\",\n" +
                "      \"totalSeconds\" : 543,\n" +
                "      \"studyProgress\" : \"未观看 / 09:03\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第58章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2398,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第59课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 59,\n" +
                "      \"videoId\" : 1633,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1633,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"09:48\",\n" +
                "      \"totalSeconds\" : 588,\n" +
                "      \"studyProgress\" : \"未观看 / 09:48\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第59章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    }, {\n" +
                "      \"id\" : 2399,\n" +
                "      \"name\" : \"《沃尔法特小提琴练习曲60首》第60课\",\n" +
                "      \"courseId\" : 398,\n" +
                "      \"lectureId\" : 0,\n" +
                "      \"testconfigId\" : 0,\n" +
                "      \"showIndex\" : 60,\n" +
                "      \"videoId\" : 1631,\n" +
                "      \"type\" : 0,\n" +
                "      \"chapterPrice\" : 1.0,\n" +
                "      \"liveId\" : 1631,\n" +
                "      \"notDraggable\" : 0,\n" +
                "      \"packageId\" : 0,\n" +
                "      \"teacherId\" : 0,\n" +
                "      \"chapterIsBuy\" : false,\n" +
                "      \"isShowTest\" : 0,\n" +
                "      \"score\" : 0.0,\n" +
                "      \"watchMinute\" : \"00:00\",\n" +
                "      \"lastWatchTime\" : 0,\n" +
                "      \"watchComplete\" : 0,\n" +
                "      \"lastWatchTimeText\" : \"未观看\",\n" +
                "      \"videoTime\" : \"14:46\",\n" +
                "      \"totalSeconds\" : 886,\n" +
                "      \"studyProgress\" : \"未观看 / 14:46\",\n" +
                "      \"liveStatus\" : 2,\n" +
                "      \"showIndexText\" : \"第60章\",\n" +
                "      \"liveTime\" : \"上课啦\"\n" +
                "    } ],\n" +
                "    \"shareView\" : {\n" +
                "      \"sharePic\" : \"http://ali-files.yooshow.com/2017/01/24/03f07dc9-407f-4157-a2e7-b76b2d51f80f.jpg\",\n" +
                "      \"shareTitle\" : \"我在央音在线上获得了一个红包奖学金，今天学习了：《沃尔法特小提琴练习曲60首》。\",\n" +
                "      \"shareUrl\" : \"http://m.immedc.com/fenxiang/course?id=398\",\n" +
                "      \"shareContent\" : \"中央音乐学院管弦系 副教授 小提琴演奏家陈曦|付费课程可试看\"\n" +
                "    },\n" +
                "    \"previewUrl\" : \"yPb7v1LZHyET3i2oQbh8cSp+GlyRKN1KUMdv2w7SkP7Do0jYL3Otez8G5fA8ojW94iaOSB3a/YXHdOjLzLsQZD9B4cewJWL+HRg9JsxCJJ6fFykAZGfnjzs70k5pz878H276CfGb7F4FBOFSNgX/Pn5HYOBnDR0I6/2dk1l0r9mVwIOdeZKzNTCF1D8aItnFvY8HFrFAAnScW3fI1Z7Wcw==\",\n" +
                "    \"lastPlaySecond\" : 0,\n" +
                "    \"playSeconds\" : 0,\n" +
                "    \"draggable\" : true,\n" +
                "    \"vip\" : false\n" +
                "  }\n" +
                "}\n";
        return s;
    }
}
