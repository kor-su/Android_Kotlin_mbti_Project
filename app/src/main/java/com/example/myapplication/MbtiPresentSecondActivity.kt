package com.example.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_mbti_present_second.*
import kotlinx.android.synthetic.main.activity_mbti_present_second_item.*

class MbtiPresentSecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mbti_present_second)

        val mbtiList = arrayListOf(
            InfpData(R.drawable.infp_1, "공기정화식물", 16900, "원"),
            InfpData(R.drawable.infp_2, "곰도리 ver 빅후드담요", 29800, "원"),
            InfpData(R.drawable.infp_3, "딸기곰 수면 잠옷 세트", 25900, "원" ),
            InfpData(R.drawable.infp_4, "8가지 꽃과일향 차 선물세트", 25900, "원"),
            InfpData(R.drawable.infp_5, "작은 별이지만 빛나고 있어", 13500, "원"),
            InfpData(R.drawable.infp_6, "잘했고 잘하고 있고 잘 될것이다", 13500, "원"),
            InfpData(R.drawable.infp_7, "안녕 소중한 사람(책+생화 꽃다발)", 36000, "원"),
            InfpData(R.drawable.infp_8, "네이처메이드 기저귀 밴드", 44900, "원"),
            InfpData(R.drawable.infp_9, "Apple 에어팟 프로", 289000, "원"),
            InfpData(R.drawable.infp_10, "아름다운 혼합 꽃상자", 55200, "원"),
            InfpData(R.drawable.infp_11, "축하 메시지 화분", 29900, "원"),
            InfpData(R.drawable.infp_12, "가을 향기 미니꽃다발", 15900, "원"),
            InfpData(R.drawable.infp_13, "빨강머리앤 감성 콜라보 파자마", 32900, "원"),
            InfpData(R.drawable.infp_14, "캐시미어 혼방머플러", 27000, "원"),
            InfpData(R.drawable.infp_15, "부채살 300g+프라임 등급 척아이롤 400g", 29900, "원"),
            InfpData(R.drawable.infp_16, "제주감귤 2.5kg", 12900, "원"),
            InfpData(R.drawable.infp_17, "M35 필름 다회용 토이카메라+코탁필름 36컷 Set 모음전", 39000, "원"),
            InfpData(R.drawable.infp_18, "겨울왕국 올라프 미니 가습기", 27900, "원"),
            InfpData(R.drawable.infp_19, "커플 잠옷", 39900, "원"),
            InfpData(R.drawable.infp_20, "고당도 프리미엄 샤인 머스켓 650g", 21900, "원"),
            InfpData(R.drawable.infp_21, "우리는 조구만 존재야", 12150, "원"),
            InfpData(R.drawable.infp_22, "출산 후 회복을 위한 붓기 쏙 박스", 29700, "원"),
            InfpData(R.drawable.infp_23, "삼성 갤럭시 워치 4(40mm)", 255550, "원"),
            InfpData(R.drawable.infp_24, "아이쿵 머리쿵 머리보호대", 17900, "원"),
            InfpData(R.drawable.infp_25, "포포베 차량용 방향제 선물 패키지", 19800,"원"),
            InfpData(R.drawable.infp_26, "5년 후의 나에게 Q&A a day", 29070,"원"),
            InfpData(R.drawable.infp_27, "이베리코 돼지고기 플루마+목살+항정살+듀록삼겹살 4종 1.2kg", 32800,"원"),
            InfpData(R.drawable.infp_28, "친호낙여 딸랑이 6종 세트", 31200,"원"),
            InfpData(R.drawable.infp_29, "멀티비타민 6종 택1", 27000,"원"),
            InfpData(R.drawable.infp_30, "모찌모찌 반능베개 찹설떡 쿠션 필로우", 29900,"원"),

        )

        mbti_present_recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mbti_present_recyclerview.setHasFixedSize(true)

        mbti_present_recyclerview.adapter = RecyclerViewAdapter(mbtiList)

    }

}