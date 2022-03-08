package com.example.risingcamp.week4_hw

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.risingcamp.R
import com.example.risingcamp.databinding.ActivityTacoMainBinding

class TacoMain : AppCompatActivity() {

    private lateinit var binding : ActivityTacoMainBinding

    //[Thread]
    //TimerThread, TacoNo(1~8)Thread, ScoreThread
    private var timerThread : TimerThread? = null
    private var tacoNo1Thread : TacoNo1Thread? = null
    private var tacoNo2Thread : TacoNo2Thread? = null
    private var tacoNo3Thread : TacoNo3Thread? = null
    private var tacoNo4Thread : TacoNo4Thread? = null
    private var tacoNo5Thread : TacoNo5Thread? = null
    private var tacoNo6Thread : TacoNo6Thread? = null
    private var tacoNo7Thread : TacoNo7Thread? = null
    private var tacoNo8Thread : TacoNo8Thread? = null
    private var scoreThread : ScoreThread? = null

    //[Handler]
    //TimerHandler
    val START = 1
    val END = 2
    val TACO_MAN_ANGRY = 3
    val TACO_MAN_MAD = 4
    var total = 100  /* 타이머 시간 */
    var started = true

    var count = 0
    var count2 = 0
    var count3 = 0
    var count4 = 0
    var count5 = 0
    var count6 = 0
    var count7 = 0
    var count8 = 0

    var state1 = false
    var state2 = false
    var state3 = false
    var state4 = false
    var state5 = false
    var state6 = false
    var state7 = false
    var state8 = false

    //TacoStateHandler
    val NO_1 = 5
    val NO_2 = 6
    val NO_3 = 7
    val NO_4 = 8

    var state = 0
    var th_click = false
    var tb_click = false
    var sc_check = false

    //ScoreHandler
    val NO_5 = 9
    val GIVE = 10

    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTacoMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        val tb_animation = AnimationUtils.loadAnimation(this, R.anim.rotate)

        binding.tacoTime.text = total.toString()

        //타이머 스레드
        timerThread = TimerThread()
        timerThread!!.start()
        Log.d("타이머 스레드", "시직")


/*--------------------------------------------------------------------------------------------------*/
        //하단 버튼1
        binding.tacoBottom1UncheckedBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                state = 1
                if(state==1){
                    binding.tacoBottom1UncheckedBtn.setImageResource(R.drawable.taco_bottom_1_checked_btn)
                    binding.tacoBottom2UncheckedBtn.setImageResource(R.drawable.taco_bottom_2_unchecked_btn)
                    binding.tacoBottom3UncheckedBtn.setImageResource(R.drawable.taco_bottom_3_unchecked_btn)
                    binding.tacoBottom4UncheckedBtn.setImageResource(R.drawable.taco_bottom_4_unchecked_btn)
                    binding.tacoBottom5UncheckedBtn.setImageResource(R.drawable.taco_bottom_5_unchecked_btn)

                    binding.tacoToolHand.setImageResource(0)
                }
                Log.d("하단 버튼1", "state: $state 선택됨")
            }
        })
        //하단 버튼2
        binding.tacoBottom2UncheckedBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                state = 2
                if(state==2){
                    binding.tacoBottom1UncheckedBtn.setImageResource(R.drawable.taco_bottom_1_unchecked_btn)
                    binding.tacoBottom2UncheckedBtn.setImageResource(R.drawable.taco_bottom_2_checked_btn)
                    binding.tacoBottom3UncheckedBtn.setImageResource(R.drawable.taco_bottom_3_unchecked_btn)
                    binding.tacoBottom4UncheckedBtn.setImageResource(R.drawable.taco_bottom_4_unchecked_btn)
                    binding.tacoBottom5UncheckedBtn.setImageResource(R.drawable.taco_bottom_5_unchecked_btn)
                }
                Log.d("하단 버튼2", "선택됨")
            }
        })
        //하단 버튼3
        binding.tacoBottom3UncheckedBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                state = 3
                if(state==3){
                    binding.tacoBottom1UncheckedBtn.setImageResource(R.drawable.taco_bottom_1_unchecked_btn)
                    binding.tacoBottom2UncheckedBtn.setImageResource(R.drawable.taco_bottom_2_unchecked_btn)
                    binding.tacoBottom3UncheckedBtn.setImageResource(R.drawable.taco_bottom_3_checked_btn)
                    binding.tacoBottom4UncheckedBtn.setImageResource(R.drawable.taco_bottom_4_unchecked_btn)
                    binding.tacoBottom5UncheckedBtn.setImageResource(R.drawable.taco_bottom_5_unchecked_btn)
                }
                Log.d("하단 버튼3", "선택됨")
            }
        })
        //하단 버튼4
        binding.tacoBottom4UncheckedBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                state = 4
                if(state==4){
                    binding.tacoBottom1UncheckedBtn.setImageResource(R.drawable.taco_bottom_1_unchecked_btn)
                    binding.tacoBottom2UncheckedBtn.setImageResource(R.drawable.taco_bottom_2_unchecked_btn)
                    binding.tacoBottom3UncheckedBtn.setImageResource(R.drawable.taco_bottom_3_unchecked_btn)
                    binding.tacoBottom4UncheckedBtn.setImageResource(R.drawable.taco_bottom_4_checked_btn)
                    binding.tacoBottom5UncheckedBtn.setImageResource(R.drawable.taco_bottom_5_unchecked_btn)
                }
                Log.d("하단 버튼4", "선택됨")
            }
        })
        //하단 버튼5
        binding.tacoBottom5UncheckedBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                state = 5
                if(state==5){
                    binding.tacoBottom1UncheckedBtn.setImageResource(R.drawable.taco_bottom_1_unchecked_btn)
                    binding.tacoBottom2UncheckedBtn.setImageResource(R.drawable.taco_bottom_2_unchecked_btn)
                    binding.tacoBottom3UncheckedBtn.setImageResource(R.drawable.taco_bottom_3_unchecked_btn)
                    binding.tacoBottom4UncheckedBtn.setImageResource(R.drawable.taco_bottom_4_unchecked_btn)
                    binding.tacoBottom5UncheckedBtn.setImageResource(R.drawable.taco_bottom_5_checked_btn)

                    binding.tacoToolHand.setImageResource(R.drawable.taco_tool_hand)
                }
                Log.d("하단 버튼5", "선택됨")
            }
        })

        //Replay 버튼
        binding.tacoReplayBtn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                val intent = Intent(this@TacoMain, TacoFirst::class.java)
                binding.tacoReplayBtn.setImageResource(R.drawable.taco_replay_checked_btn)
                startActivity(intent)
                finish()
                Log.d("Replay버튼", "Main 화면 이동")
            }
        })
/*--------------------------------------------------------------------------------------------------*/
        //Taco 구멍 1~16
        binding.no1.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tacoNo1Thread = TacoNo1Thread()
                tacoNo1Thread!!.start()
            }
        })
        binding.no2.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                    tacoNo2Thread = TacoNo2Thread()
                    tacoNo2Thread!!.start()
            }
        })
        binding.no3.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                    tacoNo3Thread = TacoNo3Thread()
                    tacoNo3Thread!!.start()
            }
        })
        binding.no4.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                    tacoNo4Thread = TacoNo4Thread()
                    tacoNo4Thread!!.start()
            }
        })
        binding.no5.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                    tacoNo5Thread = TacoNo5Thread()
                    tacoNo5Thread!!.start()
            }
        })
        binding.no6.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                    tacoNo6Thread = TacoNo6Thread()
                    tacoNo6Thread!!.start()
            }
        })
        binding.no7.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                    tacoNo7Thread = TacoNo7Thread()
                    tacoNo7Thread!!.start()
            }
        })
        binding.no8.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                    tacoNo8Thread = TacoNo8Thread()
                    tacoNo8Thread!!.start()
            }
        })

/*--------------------------------------------------------------------------------------------------*/
        //Taco볼 1~16
        binding.tacoBallNo1.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tb_click = true
                binding.tacoBallNo1.startAnimation(tb_animation)
                tacoNo1Thread = TacoNo1Thread()
                tacoNo1Thread!!.start()
            }
        })
        binding.tacoBallNo2.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tb_click = true
                binding.tacoBallNo2.startAnimation(tb_animation)
                tacoNo2Thread = TacoNo2Thread()
                tacoNo2Thread!!.start()
            }
        })
        binding.tacoBallNo3.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tb_click = true
                binding.tacoBallNo3.startAnimation(tb_animation)
                tacoNo3Thread = TacoNo3Thread()
                tacoNo3Thread!!.start()
            }
        })
        binding.tacoBallNo4.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tb_click = true
                binding.tacoBallNo4.startAnimation(tb_animation)
                tacoNo4Thread = TacoNo4Thread()
                tacoNo4Thread!!.start()
            }
        })
        binding.tacoBallNo5.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tb_click = true
                binding.tacoBallNo5.startAnimation(tb_animation)
                tacoNo5Thread = TacoNo5Thread()
                tacoNo5Thread!!.start()
            }
        })
        binding.tacoBallNo6.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tb_click = true
                binding.tacoBallNo6.startAnimation(tb_animation)
                tacoNo6Thread = TacoNo6Thread()
                tacoNo6Thread!!.start()
            }
        })
        binding.tacoBallNo7.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tb_click = true
                binding.tacoBallNo7.startAnimation(tb_animation)
                tacoNo7Thread = TacoNo7Thread()
                tacoNo7Thread!!.start()
            }
        })
        binding.tacoBallNo8.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tb_click = true
                binding.tacoBallNo8.startAnimation(tb_animation)
                tacoNo8Thread = TacoNo8Thread()
                tacoNo8Thread!!.start()
            }
        })
/*--------------------------------------------------------------------------------------------------*/
        //도마 타코알
        binding.tacoDomaR1.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tacoNo1Thread = TacoNo1Thread()
                tacoNo1Thread!!.start()
            }
        })
        binding.tacoDomaR2.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tacoNo2Thread = TacoNo2Thread()
                tacoNo2Thread!!.start()
            }
        })
        binding.tacoDomaR3.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tacoNo3Thread = TacoNo3Thread()
                tacoNo3Thread!!.start()
            }
        })
        binding.tacoDomaR4.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tacoNo4Thread = TacoNo4Thread()
                tacoNo4Thread!!.start()
            }
        })
        binding.tacoDomaR5.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tacoNo5Thread = TacoNo5Thread()
                tacoNo5Thread!!.start()
            }
        })
        binding.tacoDomaR6.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tacoNo6Thread = TacoNo6Thread()
                tacoNo6Thread!!.start()
            }
        })
        binding.tacoDomaR7.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tacoNo7Thread = TacoNo7Thread()
                tacoNo7Thread!!.start()
            }
        })
        binding.tacoDomaR8.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                tacoNo8Thread = TacoNo8Thread()
                tacoNo8Thread!!.start()
            }
        })
/*--------------------------------------------------------------------------------------------------*/
        //손 - 타코알 건내기
        binding.tacoToolHand.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                scoreThread = ScoreThread()
                scoreThread!!.start()
            }
        })

    }
/*--------------------------------------------------------------------------------------------------*/

    //TimerHandler
    private val timer_handler = object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                START -> {
                    binding.tacoTime.text = msg.arg1.toString()
                }
                END -> {
                    binding.tacoTime.text = msg.arg2.toString()
                    binding.tacoGameOverTxt.text = "GAME OVER"
                    binding.tacoReplayBtn.setImageResource(R.drawable.taco_replay_unchecked_btn)

                    binding.tacoBottom1UncheckedBtn.isEnabled = false
                    binding.tacoBottom2UncheckedBtn.isEnabled = false
                    binding.tacoBottom3UncheckedBtn.isEnabled = false
                    binding.tacoBottom4UncheckedBtn.isEnabled = false
                    binding.tacoBottom5UncheckedBtn.isEnabled = false
                    Log.d("하단 버튼","터치 불가능")
                }
                TACO_MAN_ANGRY -> {
                    if(total<=20){
                        binding.tacoMan.setImageResource(R.drawable.taco_man_angry)
                    }
                }
                TACO_MAN_MAD -> {
                    if(total==0){
                        binding.tacoMan.visibility = View.INVISIBLE
                        binding.tacoManMad.setImageResource(R.drawable.taco_man_mad_right)
                    }
                }
            }
        }
    }
    //TimerThread
    inner class TimerThread : Thread() {
        var run = true
        override fun run() {
            while (run){
                started = true

                    while(true){
                        Thread.sleep(1000)
                        if(!started) break
                        total -= 1

                        val msg = Message()
                        msg.what = START
                        msg.arg1 = total
                        timer_handler.sendMessage(msg)

                        if(th_click == true && count >= 0){
                            count++
                            if(count==45){
                                count = -1
                            }
                            Log.d("타코타임", "total: $total, count:$count")
                        }
                        if(th_click == true && count2 >= 0){
                            count2++
                            if(count2==45){
                                count2 = -1
                            }
                            Log.d("타코타임", "total: $total, count2:$count2")
                        }
                        if(th_click == true && count3 >= 0){
                            count3++
                            if(count3==45){
                                count3 = -1
                            }
                            Log.d("타코타임", "total: $total, count3:$count3")
                        }
                        if(th_click == true && count4 >= 0){
                            count4++
                            if(count4==45){
                                count4 = -1
                            }
                            Log.d("타코타임", "total: $total, count4:$count4")
                        }
                        if(th_click == true && count5 >= 0){
                            count5++
                            if(count5==45){
                                count5 = -1
                            }
                            Log.d("타코타임", "total: $total, count5:$count5")
                        }
                        if(th_click == true && count6 >= 0){
                            count6++
                            if(count6==45){
                                count6 = -1
                            }
                            Log.d("타코타임", "total: $total, count6:$count6")
                        }
                        if(th_click == true && count7 >= 0){
                            count7++
                            if(count7==45){
                                count7 = -1
                            }
                            Log.d("타코타임", "total: $total, count7:$count7")
                        }
                        if(th_click == true && count8 >= 0){
                            count8++
                            if(count8==45){
                                count8 = -1
                            }
                            Log.d("타코타임", "total: $total, count8:$count8")
                        }

                        val msg2 = Message()
                        msg2.what = TACO_MAN_ANGRY
                        msg2.arg1 = total
                        timer_handler.sendMessage(msg2)

                        Log.d("타이머", "started: $started, startTimer")

                        if(total == 0) {
                            started=false
                            total = 0

                            val msg = Message()
                            msg.what = END
                            msg.arg2 = total
                            timer_handler.sendMessage(msg)

                            val msg2 = Message()
                            msg2.what = TACO_MAN_MAD
                            msg2.arg2 = total
                            timer_handler.sendMessage(msg2)

                            Log.d("타이머", "started: $started, stopTimer")
                        }
                    }
                run = false
            }
            super.run()
        }
    }
/*--------------------------------------------------------------------------------------------------*/
    //[TacoHandler]
    //TacoNo1Handler
    private val tacoNo1_handler = object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                NO_1 -> {
                    if(state == 1){
                        binding.no1.setImageResource(R.drawable.taco_state_1)
                        Log.d("구멍1", "주전자 선택됨")
                    }
                }
                NO_2 -> {
                    if(state == 2){
                        binding.no1.setImageResource(R.drawable.taco_state_2)
                        Log.d("구멍1", "문어 선택됨")
                    }
                }
                NO_3 -> {
                    if(state==3){
                        th_click = true
                    }
                    if(state == 3 && th_click == true){
                        binding.no1.setImageResource(0)
                        binding.tacoBallNo1.setImageResource(R.drawable.taco_r1)
                        Log.d("구멍1", "스틱 선택됨")

                        if(tb_click == true){
                            //익었을 때
                            if(count < 25){
                                state1 = false
                                binding.tacoBallNo1.setImageResource(R.drawable.taco_r1)
                            } else if(count >= 25 && count < 35){
                                state1 = true
                                binding.tacoBallNo1.setImageResource(R.drawable.taco_r2)
                                binding.tacoBallNo1.setOnClickListener{
                                    //익은 타코 도마로 이동
                                    binding.tacoBallNo1.setImageResource(0)
                                    binding.tacoDomaR1.setImageResource(R.drawable.taco_r2)
                                }
                            }
                            //탔을 때
                            else if (count > 35){
                                state1 = false
                                binding.tacoBallNo1.setImageResource(R.drawable.taco_r4)
                                binding.tacoBallNo1.setOnClickListener{
                                    binding.tacoBallNo1.setImageResource(0)
                                    }
                                }
                            }
                    }
                }
                NO_4 -> {
                    if(state==4){
                        sc_check = true
                        if(state1 == sc_check){
                            binding.tacoDomaR1.setOnClickListener{
                                //타코 알에 소스 바르기
                                binding.tacoDomaR1.setImageResource(R.drawable.taco_r3)
                            }
                            Log.d("소스바르기", "state1:$state1")
                        }
                    }
                }
            }
        }
    }
    //TacoNo1Thread
    inner class TacoNo1Thread : Thread() {
        var run = true
        override fun run() {
            while (run){
                val msg = Message()
                msg.what = NO_1
                tacoNo1_handler.sendMessage(msg)

                val msg2 = Message()
                msg2.what = NO_2
                tacoNo1_handler.sendMessage(msg2)

                val msg3 = Message()
                msg3.what = NO_3
                tacoNo1_handler.sendMessage(msg3)

                val msg4 = Message()
                msg4.what = NO_4
                tacoNo1_handler.sendMessage(msg4)

                run = false
            }
            super.run()
        }
    }

    //TacoNo2Handler
    private val tacoNo2_handler = object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                NO_1 -> {
                    if(state == 1){
                        binding.no2.setBackgroundResource(R.drawable.taco_state_1)
                        Log.d("구멍2", "주전자 선택됨")
                    }
                }
                NO_2 -> {
                    if(state == 2){
                        binding.no2.setBackgroundResource(R.drawable.taco_state_2)
                        Log.d("구멍2", "문어 선택됨")
                    }
                }
                NO_3 -> {
                    if(state==3){
                        th_click = true
                    }
                    if(state == 3 && th_click == true){
                        binding.no2.setBackgroundResource(0)
                        binding.tacoBallNo2.setImageResource(R.drawable.taco_r1)
                        Log.d("구멍2", "스틱 선택됨")

                        if(tb_click == true){
                            //익었을 때
                            if(count2 < 25){
                                state2 = false
                                binding.tacoBallNo2.setImageResource(R.drawable.taco_r1)
                            } else if(count2 >= 25 && count2 < 35){
                                state2 = true
                                binding.tacoBallNo2.setImageResource(R.drawable.taco_r2)
                                binding.tacoBallNo2.setOnClickListener{
                                    //익은 타코 도마로 이동
                                    binding.tacoBallNo2.setImageResource(0)
                                    binding.tacoDomaR2.setImageResource(R.drawable.taco_r2)
                                }
                            }
                            //탔을 때
                            else if (count2 >= 35){
                                state2 = false
                                binding.tacoBallNo2.setImageResource(R.drawable.taco_r4)
                                binding.tacoBallNo2.setOnClickListener{
                                    binding.tacoBallNo2.setImageResource(0)
                                }
                            }
                        }
                    }
                }
                NO_4 -> {
                    if(state==4){
                        sc_check = true
                        if(state2 == sc_check){
                            binding.tacoDomaR2.setOnClickListener{
                                //타코 알에 소스 바르기
                                binding.tacoDomaR2.setImageResource(R.drawable.taco_r3)
                            }
                            Log.d("소스바르기", "state2:$state2")
                        }
                    }
                }
            }
        }
    }
    //TacoNo2Thread
    inner class TacoNo2Thread : Thread() {
        var run = true
        override fun run() {
            while (run){
                val msg = Message()
                msg.what = NO_1
                tacoNo2_handler.sendMessage(msg)

                val msg2 = Message()
                msg2.what = NO_2
                tacoNo2_handler.sendMessage(msg2)

                val msg3 = Message()
                msg3.what = NO_3
                tacoNo2_handler.sendMessage(msg3)

                val msg4 = Message()
                msg4.what = NO_4
                tacoNo2_handler.sendMessage(msg4)

                run = false
            }
            super.run()
        }
    }

    //TacoNo3Handler
    private val tacoNo3_handler = object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                NO_1 -> {
                    if(state == 1){
                        binding.no3.setBackgroundResource(R.drawable.taco_state_1)
                        Log.d("구멍3", "주전자 선택됨")
                    }
                }
                NO_2 -> {
                    if(state == 2){
                        binding.no3.setBackgroundResource(R.drawable.taco_state_2)
                        Log.d("구멍3", "문어 선택됨")
                    }
                }
                NO_3 -> {
                    if(state==3){
                        th_click = true
                    }
                    if(state == 3 && th_click == true){
                        binding.no3.setBackgroundResource(0)
                        binding.tacoBallNo3.setImageResource(R.drawable.taco_r1)
                        Log.d("구멍3", "스틱 선택됨")

                        if(tb_click == true){
                            //익었을 때
                            if(count3 < 25){
                                state3 = false
                                binding.tacoBallNo3.setImageResource(R.drawable.taco_r1)
                            } else if(count3 >= 25 && count3 < 35){
                                state3 = true
                                binding.tacoBallNo3.setImageResource(R.drawable.taco_r2)
                                binding.tacoBallNo3.setOnClickListener{
                                    //익은 타코 도마로 이동
                                    binding.tacoBallNo3.setImageResource(0)
                                    binding.tacoDomaR3.setImageResource(R.drawable.taco_r2)
                                }
                            }
                            //탔을 때
                            else if (count3 >= 35){
                                state3 = false
                                binding.tacoBallNo3.setImageResource(R.drawable.taco_r4)
                                binding.tacoBallNo3.setOnClickListener{
                                    binding.tacoBallNo3.setImageResource(0)
                                }
                            }
                        }
                    }
                }
                NO_4 -> {
                    if(state==4){
                        sc_check = true
                        if(state3 == sc_check){
                            binding.tacoDomaR3.setOnClickListener{
                                //타코 알에 소스 바르기
                                binding.tacoDomaR3.setImageResource(R.drawable.taco_r3)
                            }
                            Log.d("소스바르기", "state3:$state3")
                        }
                    }
                }
            }
        }
    }
    //TacoNo3Thread
    inner class TacoNo3Thread : Thread() {
        var run = true
        override fun run() {
            while (run){
                val msg = Message()
                msg.what = NO_1
                tacoNo3_handler.sendMessage(msg)

                val msg2 = Message()
                msg2.what = NO_2
                tacoNo3_handler.sendMessage(msg2)

                val msg3 = Message()
                msg3.what = NO_3
                tacoNo3_handler.sendMessage(msg3)

                val msg4 = Message()
                msg4.what = NO_4
                tacoNo3_handler.sendMessage(msg4)

                run = false
            }
            super.run()
        }
    }

    //TacoNo4Handler
    private val tacoNo4_handler = object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                NO_1 -> {
                    if(state == 1){
                        binding.no4.setBackgroundResource(R.drawable.taco_state_1)
                        Log.d("구멍4", "주전자 선택됨")
                    }
                }
                NO_2 -> {
                    if(state == 2){
                        binding.no4.setBackgroundResource(R.drawable.taco_state_2)
                        Log.d("구멍4", "문어 선택됨")
                    }
                }
                NO_3 -> {
                    if(state==3){
                        th_click = true
                    }
                    if(state == 3 && th_click == true){
                        binding.no4.setBackgroundResource(0)
                        binding.tacoBallNo4.setImageResource(R.drawable.taco_r1)
                        Log.d("구멍4", "스틱 선택됨")

                        if(tb_click == true){
                            //익었을 때
                            if(count4 < 25){
                                state4 = false
                                binding.tacoBallNo4.setImageResource(R.drawable.taco_r1)
                            } else if(count4 >= 25 && count4 < 35){
                                state4 = true
                                binding.tacoBallNo4.setImageResource(R.drawable.taco_r2)
                                binding.tacoBallNo4.setOnClickListener{
                                    //익은 타코 도마로 이동
                                    binding.tacoBallNo4.setImageResource(0)
                                    binding.tacoDomaR4.setImageResource(R.drawable.taco_r2)
                                }
                            }
                            //탔을 때
                            else if (count4 >= 35){
                                state4 = false
                                binding.tacoBallNo4.setImageResource(R.drawable.taco_r4)
                                binding.tacoBallNo4.setOnClickListener{
                                    binding.tacoBallNo4.setImageResource(0)
                                }
                            }
                        }
                    }
                }
                NO_4 -> {
                    if(state==4){
                        sc_check = true
                        if(state4 == sc_check){
                            binding.tacoDomaR4.setOnClickListener{
                                //타코 알에 소스 바르기
                                binding.tacoDomaR4.setImageResource(R.drawable.taco_r3)
                            }
                            Log.d("소스바르기", "state4:$state4")
                        }
                    }
                }
            }
        }
    }
    //TacoNo4Thread
    inner class TacoNo4Thread : Thread() {
        var run = true
        override fun run() {
            while (run){
                val msg = Message()
                msg.what = NO_1
                tacoNo4_handler.sendMessage(msg)

                val msg2 = Message()
                msg2.what = NO_2
                tacoNo4_handler.sendMessage(msg2)

                val msg3 = Message()
                msg3.what = NO_3
                tacoNo4_handler.sendMessage(msg3)

                val msg4 = Message()
                msg4.what = NO_4
                tacoNo4_handler.sendMessage(msg4)

                run = false
            }
            super.run()
        }
    }

    //TacoNo5Handler
    private val tacoNo5_handler = object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                NO_1 -> {
                    if(state == 1){
                        binding.no5.setBackgroundResource(R.drawable.taco_state_1)
                        Log.d("구멍5", "주전자 선택됨")
                    }
                }
                NO_2 -> {
                    if(state == 2){
                        binding.no5.setBackgroundResource(R.drawable.taco_state_2)
                        Log.d("구멍5", "문어 선택됨")
                    }
                }
                NO_3 -> {
                    if(state==3){
                        th_click = true
                    }
                    if(state == 3 && th_click == true){
                        binding.no5.setBackgroundResource(0)
                        binding.tacoBallNo5.setImageResource(R.drawable.taco_r1)
                        Log.d("구멍5", "스틱 선택됨")

                        if(tb_click == true){
                            //익었을 때
                            if(count5 < 25){
                                state5 = false
                                binding.tacoBallNo5.setImageResource(R.drawable.taco_r1)
                            } else if(count5 >= 25 && count5 < 35){
                                state5 = true
                                binding.tacoBallNo5.setImageResource(R.drawable.taco_r2)
                                binding.tacoBallNo5.setOnClickListener{
                                    //익은 타코 도마로 이동
                                    binding.tacoBallNo5.setImageResource(0)
                                    binding.tacoDomaR5.setImageResource(R.drawable.taco_r2)
                                }
                            }
                            //탔을 때
                            else if (count5 >= 35){
                                state5 = false
                                binding.tacoBallNo5.setImageResource(R.drawable.taco_r4)
                                binding.tacoBallNo5.setOnClickListener{
                                    binding.tacoBallNo5.setImageResource(0)
                                }
                            }
                        }
                    }
                }
                NO_4 -> {
                    if(state==4){
                        sc_check = true
                        if(state5 == sc_check){
                            binding.tacoDomaR5.setOnClickListener{
                                //타코 알에 소스 바르기
                                binding.tacoDomaR5.setImageResource(R.drawable.taco_r3)
                            }
                            Log.d("소스바르기", "state5:$state5")
                        }
                    }
                }
            }
        }
    }

    //TacoNo5Thread
    inner class TacoNo5Thread : Thread() {
        var run = true
        override fun run() {
            while (run){
                val msg = Message()
                msg.what = NO_1
                tacoNo5_handler.sendMessage(msg)

                val msg2 = Message()
                msg2.what = NO_2
                tacoNo5_handler.sendMessage(msg2)

                val msg3 = Message()
                msg3.what = NO_3
                tacoNo5_handler.sendMessage(msg3)

                val msg4 = Message()
                msg4.what = NO_4
                tacoNo5_handler.sendMessage(msg4)

                run = false
            }
            super.run()
        }
    }

    //TacoNo6Handler
    private val tacoNo6_handler = object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                NO_1 -> {
                    if(state == 1){
                        binding.no6.setBackgroundResource(R.drawable.taco_state_1)
                        Log.d("구멍6", "주전자 선택됨")
                    }
                }
                NO_2 -> {
                    if(state == 2){
                        binding.no6.setBackgroundResource(R.drawable.taco_state_2)
                        Log.d("구멍6", "문어 선택됨")
                    }
                }
                NO_3 -> {
                    if(state==3){
                        th_click = true
                    }
                    if(state == 3 && th_click == true){
                        binding.no6.setBackgroundResource(0)
                        binding.tacoBallNo6.setImageResource(R.drawable.taco_r1)
                        Log.d("구멍6", "스틱 선택됨")

                        if(tb_click == true){
                            //익었을 때
                            if(count6 < 25){
                                state6 = false
                                binding.tacoBallNo6.setImageResource(R.drawable.taco_r1)
                            } else if(count6 >= 25 && count6 < 35){
                                state6 = true
                                binding.tacoBallNo6.setImageResource(R.drawable.taco_r2)
                                binding.tacoBallNo6.setOnClickListener{
                                    //익은 타코 도마로 이동
                                    binding.tacoBallNo6.setImageResource(0)
                                    binding.tacoDomaR6.setImageResource(R.drawable.taco_r2)
                                }
                            }
                            //탔을 때
                            else if (count6 >= 35){
                                state6 = false
                                binding.tacoBallNo6.setImageResource(R.drawable.taco_r4)
                                binding.tacoBallNo6.setOnClickListener{
                                    binding.tacoBallNo6.setImageResource(0)
                                }
                            }
                        }
                    }
                }
                NO_4 -> {
                    if(state==4){
                        sc_check = true
                        if(state6 == sc_check){
                            binding.tacoDomaR6.setOnClickListener{
                                //타코 알에 소스 바르기
                                binding.tacoDomaR6.setImageResource(R.drawable.taco_r3)
                            }
                            Log.d("소스바르기", "state6:$state6")
                        }
                    }
                }
            }
        }
    }

    //TacoNo6Thread
    inner class TacoNo6Thread : Thread() {
        var run = true
        override fun run() {
            while (run){
                val msg = Message()
                msg.what = NO_1
                tacoNo6_handler.sendMessage(msg)

                val msg2 = Message()
                msg2.what = NO_2
                tacoNo6_handler.sendMessage(msg2)

                val msg3 = Message()
                msg3.what = NO_3
                tacoNo6_handler.sendMessage(msg3)

                val msg4 = Message()
                msg4.what = NO_4
                tacoNo6_handler.sendMessage(msg4)

                run = false
            }
            super.run()
        }
    }

    //TacoNo7Handler
    private val tacoNo7_handler = object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                NO_1 -> {
                    if(state == 1){
                        binding.no7.setBackgroundResource(R.drawable.taco_state_1)
                        Log.d("구멍7", "주전자 선택됨")
                    }
                }
                NO_2 -> {
                    if(state == 2){
                        binding.no7.setBackgroundResource(R.drawable.taco_state_2)
                        Log.d("구멍7", "문어 선택됨")
                    }
                }
                NO_3 -> {
                    if(state==3){
                        th_click = true
                    }
                    if(state == 3 && th_click == true){
                        binding.no7.setBackgroundResource(0)
                        binding.tacoBallNo7.setImageResource(R.drawable.taco_r1)
                        Log.d("구멍1", "스틱 선택됨")

                        if(tb_click == true){
                            //익었을 때
                            if(count7 < 25){
                                state7 = false
                                binding.tacoBallNo7.setImageResource(R.drawable.taco_r1)
                            } else if(count7 >= 25 && count7 < 35){
                                state7 = true
                                binding.tacoBallNo7.setImageResource(R.drawable.taco_r2)
                                binding.tacoBallNo7.setOnClickListener{
                                    //익은 타코 도마로 이동
                                    binding.tacoBallNo7.setImageResource(0)
                                    binding.tacoDomaR7.setImageResource(R.drawable.taco_r2)
                                }
                            }
                            //탔을 때
                            else if (count7 >= 35){
                                state7 = false
                                binding.tacoBallNo7.setImageResource(R.drawable.taco_r4)
                                binding.tacoBallNo7.setOnClickListener{
                                    binding.tacoBallNo7.setImageResource(0)
                                }
                            }
                        }
                    }
                }
                NO_4 -> {
                    if(state==4){
                        sc_check = true
                        if(state7 == sc_check){
                            binding.tacoDomaR7.setOnClickListener{
                                //타코 알에 소스 바르기
                                binding.tacoDomaR7.setImageResource(R.drawable.taco_r3)
                            }
                            Log.d("소스바르기", "state7:$state7")
                        }
                    }
                }
            }
        }
    }
    //TacoNo7Thread
    inner class TacoNo7Thread : Thread() {
        var run = true
        override fun run() {
            while (run){
                val msg = Message()
                msg.what = NO_1
                tacoNo7_handler.sendMessage(msg)

                val msg2 = Message()
                msg2.what = NO_2
                tacoNo7_handler.sendMessage(msg2)

                val msg3 = Message()
                msg3.what = NO_3
                tacoNo7_handler.sendMessage(msg3)

                val msg4 = Message()
                msg4.what = NO_4
                tacoNo7_handler.sendMessage(msg4)

                run = false
            }
            super.run()
        }
    }

    //TacoNo8Handler
    private val tacoNo8_handler = object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                NO_1 -> {
                    if(state == 1){
                        binding.no8.setBackgroundResource(R.drawable.taco_state_1)
                        Log.d("구멍8", "주전자 선택됨")
                    }
                }
                NO_2 -> {
                    if(state == 2){
                        binding.no8.setBackgroundResource(R.drawable.taco_state_2)
                        Log.d("구멍8", "문어 선택됨")
                    }
                }
                NO_3 -> {
                    if(state==3){
                        th_click = true
                    }
                    if(state == 3 && th_click == true){
                        binding.no8.setBackgroundResource(0)
                        binding.tacoBallNo8.setImageResource(R.drawable.taco_r1)
                        Log.d("구멍8", "스틱 선택됨")

                        if(tb_click == true){
                            //익었을 때
                            if(count8 < 25){
                                state8 = false
                                binding.tacoBallNo8.setImageResource(R.drawable.taco_r1)
                            } else if(count8 >= 25 && count8 < 35){
                                state8 = true
                                binding.tacoBallNo8.setImageResource(R.drawable.taco_r2)
                                binding.tacoBallNo8.setOnClickListener{
                                    //익은 타코 도마로 이동
                                    binding.tacoBallNo8.setImageResource(0)
                                    binding.tacoDomaR8.setImageResource(R.drawable.taco_r2)
                                }
                            }
                            //탔을 때
                            else if (count8 >= 35){
                                state8 = false
                                binding.tacoBallNo8.setImageResource(R.drawable.taco_r4)
                                binding.tacoBallNo8.setOnClickListener{
                                    binding.tacoBallNo8.setImageResource(0)
                                }
                            }
                        }
                    }
                }
                NO_4 -> {
                    if(state==4){
                        sc_check = true
                        if(state8 == sc_check){
                            binding.tacoDomaR8.setOnClickListener{
                                //타코 알에 소스 바르기
                                binding.tacoDomaR8.setImageResource(R.drawable.taco_r3)
                            }
                            Log.d("소스바르기", "state8:$state8")
                        }
                    }
                }
            }
        }
    }
    //TacoNo8Thread
    inner class TacoNo8Thread : Thread() {
        var run = true
        override fun run() {
            while (run){
                val msg = Message()
                msg.what = NO_1
                tacoNo8_handler.sendMessage(msg)

                val msg2 = Message()
                msg2.what = NO_2
                tacoNo8_handler.sendMessage(msg2)

                val msg3 = Message()
                msg3.what = NO_3
                tacoNo8_handler.sendMessage(msg3)

                val msg4 = Message()
                msg4.what = NO_4
                tacoNo8_handler.sendMessage(msg4)

                run = false
            }
            super.run()
        }
    }

/*--------------------------------------------------------------------------------------------------*/
    //[Score]
    //ScoreHandler
    private val score_handler = object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when(msg.what) {
                GIVE -> {
                    if(state1==true){
                        score += 20
                    }
                    if(state2==true){
                        score += 20
                    }
                    if(state3==true){
                        score += 20
                    }
                    if(state4==true){
                        score += 20
                    }
                    if(state5==true){
                        score += 20
                    }
                    if(state6==true){
                        score += 20
                    }
                    if(state7==true){
                        score += 20
                    }
                    if(state8==true){
                        score += 20
                    }
                }
                NO_5 -> {
                    if(state==5){
                        binding.tacoDomaR1.setImageResource(0)
                        binding.tacoDomaR2.setImageResource(0)
                        binding.tacoDomaR3.setImageResource(0)
                        binding.tacoDomaR4.setImageResource(0)
                        binding.tacoDomaR5.setImageResource(0)
                        binding.tacoDomaR6.setImageResource(0)
                        binding.tacoDomaR7.setImageResource(0)
                        binding.tacoDomaR8.setImageResource(0)
                        binding.tacoScore.text = score.toString()
                    }
                }
            }
        }
    }
    //ScoreThread
    inner class ScoreThread : Thread() {
        var run = true
        override fun run() {
            while (run){

                val msg = Message()
                msg.what = GIVE
                score_handler.sendMessage(msg)

                val msg2 = Message()
                msg2.what = NO_5
                score_handler.sendMessage(msg2)

                run = false
            }
            super.run()
        }
    }

}
