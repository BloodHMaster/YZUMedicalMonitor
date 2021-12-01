<template>
    <el-row class="home" :getter="20">
        <el-col :span="8" style="margin-top:20px">
            <el-card shadow="hover">
                <div class="user">
                    <img :src="userImg" alt="">
                    <div class="userinfo">
                        <p class="name">Admin</p>
                        <p class="access">普通用户</p>
                    </div>
                </div>
                <div class="login-info">
                    <p>上次登录时间：<span>2021-11-1</span></p>
                    <p>上次登录地点：<span>扬州</span></p>
                </div>
            </el-card>
            <el-card shadow="hover" style="height:450px;margin-top:20px">
                <el-table :data="tableData" :row-style="{height:'50px'}">
                    <el-table-column prop="infoname" width="180" ></el-table-column>
                    <el-table-column prop="infomation" ></el-table-column>
                </el-table>
            </el-card>
        </el-col>
        <el-col :span="16" style="margin-top:20px">
            <div class="num">
                <el-card
                 shadow="hover" 
                 v-for="item in countData" 
                 :key="item.name" 
                 :body-style="{display:'flex',padding: 0}"
                >
                    <i
                     class="icon" 
                     :class="`el-icon-${item.icon}`" 
                     :style="{background:item.color}"
                    ></i>
                    <div class="detail">
                        <p class="num">{{item.value + item.unit}}</p>
                        <p class="txt">{{item.name}}</p>
                    </div>
                </el-card>
            </div>
            <el-card shadow="hover" style="width:98%; height:280px; margin-left:2%">
                <div id="Linechart" style="width: 98%;height:250px;"></div>
            </el-card>
            <div class="graph">
                <el-card shadow="hover" style="width:47%; height:280px; margin-left:2%;" body-style="{display:'flex',padding: 0}">
                    <div id="Barchart"></div>
                </el-card>
                <el-card shadow="hover" style="width:47%; height:280px; margin-left:2%;" body-style="{display:'flex',padding: 0}">
                    <div id="Piechart"></div>
                </el-card>
            </div>
        </el-col>
    </el-row>
</template>

<script>
import * as echarts from "echarts";
import Vue from 'vue';
export default {
    data(){
        return{
            userImg:require("../../assets/images/user.png"),
            tableData:[
                {
                    infoname:"姓名",
                    infomation:"张三",
                },
                {
                    infoname:"年龄",
                    infomation:20,
                },
                {
                    infoname:"性别",
                    infomation:"男",
                },
                {
                    infoname:"手机号",
                    infomation:"13228865458",
                },
                {
                    infoname:"血型",
                    infomation:"O",
                },
                {
                    infoname:"身高",
                    infomation:175+"cm",
                },
                {
                    infoname:"体重",
                    infomation:65+"kg",
                },
            ],
            countData:[
                {
                    name:"心率",
                    value:87,
                    unit:"次/分",
                    icon:"success",
                    color:"#2ec7c9",
                },
                {
                    name:"血压(收缩压)",
                    value:109,
                    unit:"mmHg",
                    icon:"s-open",
                    color:"#ffb980",
                },
                {
                    name:"已收藏药物",
                    value:11,
                    unit:"副",
                    icon:"star-on",
                    color:"#1E90FF",
                },
                {
                    name:"脉搏",
                    value:87,
                    unit:"次/分",
                    icon:"success",
                    color:"#2ec7c9",
                },
                {
                    name:"血压(舒张压)",
                    value:68,
                    unit:"mmHg",
                    icon:"s-open",
                    color:"#ffb980",
                },
                {
                    name:"已收藏医师",
                    value:5,
                    unit:"个",
                    icon:"star-on",
                    color:"#1E90FF",
                },
            ],
            legendData:['心率(次/分)','血压(收缩压)','血压(舒张压)'],  //图例数据
            echartData0:[78,80,85,69,78,74,68,98,95,87],
            echartData1:[114,102,118,106,120,118,105,113,118,109],
            echartData2:[66,80,78,68,70,74,69,80,61,68],
        }
    },
    mounted(){
        this.$nextTick(function() {
				this.drawLine('Linechart'),
                this.drawBar('Barchart'),
                this.drawPie('Piechart')
			})
    },
    created() {
			/* 每1分钟进行一次刷新 */
			setInterval(()=>{
				this.list();
                this.echartData0.splice(0,1);
                this.echartData0.push(this.countData[0].value);
                this.echartData1.splice(0,1);
                this.echartData1.push(this.countData[1].value);
                this.echartData2.splice(0,1);
                this.echartData2.push(this.countData[4].value);
                this.drawLine('Linechart');
			}, 1000 * 60);
		},
    methods:{
        //随机生成数据
        list() {
            this.countData[0].value=Math.floor(Math.random()*40+60);
            this.countData[1].value=Math.floor(Math.random()*20+100);
            this.countData[3].value=this.countData[0].value;
            this.countData[4].value=Math.floor(Math.random()*20+60);
        },
        //返回指定年月的天数
        getDaysInMonth(year,month){
            let temp = new Date(year,month,0);
            let days = temp.getDate(); //这里mm就是天数啦
            return days;
        },
        //返回当前日期前pre天
        getNowDate(pre){
            let nowDate = new Date();
            let day = nowDate.getDate();
            let month = nowDate.getMonth() + 1;
            let year = nowDate.getFullYear();
            if(day <= pre)
            {
                if(month > 1)
                {
                    month = month -1;
                    day = this.getDaysInMonth(year,month) + day - pre;
                }
                else
                {
                    year = year - 1;
                    month = 12;
                    day = this.getDaysInMonth(year,month) + day - pre;
                }
            }
            else
            {
                day = day - pre;
            }
            return year + '/\n' + month + '/' + day;
        },
        //折线图
        drawLine(id) {
            this.charts = echarts.init(document.getElementById(id));
            this.charts.setOption({
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    selected:{},
                    selectedMode:'single',
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: ["1","2","3","4","5","6","7","8","9","10"]
                },
                yAxis: {
                    type: 'value'
                },

                series: [
                    {
                        name: '心率(次/分)',
                        type: 'line',
                        data:this.echartData0,
                    },
                    {
                        name: '血压(收缩压)',
                        type: 'line',
                        data:this.echartData1,
                    },
                    {
                        name: '血压(舒张压)',
                        type: 'line',
                        data:this.echartData2,
                    },
                ]
            })
		},
        //柱状图
        drawBar(id){
            this.charts = echarts.init(document.getElementById(id));
            this.charts.setOption({
                legend:{
                    textStyle:{color:"#333",},
                },
                grid:{left:"10%",},
                tooltip:{trigger:'axis',},
                xAxis:{
                    type:"category",
                    data:[this.getNowDate(6),this.getNowDate(5),this.getNowDate(4),this.getNowDate(3),
                        this.getNowDate(2),this.getNowDate(1),this.getNowDate(0)],
                    axisLine:{
                        lineStyle:{color:"#17b3a3",},
                    },
                    axisLabel:{
                        interval:0,
                        color:"#333",
                    },
                },
                yAxis:[
                    {
                        type:"value",
                        axisLine:{
                            lineStyle:{
                                textStyle:{color:"#17b3a3",},
                            },
                        },
                    },
                ],
                color:["#2ec7c9", "#b6a2de"],
                series:[
                    {
                        name:"当日浏览药物数",
                        data:this.echartData0,
                        type:"bar",
                    },
                    {
                        name:"当日浏览医师数",
                        data:this.echartData1,
                        type:"bar",
                    }
                ],
            })
        },
        //饼图
        drawPie(id){
            this.charts = echarts.init(document.getElementById(id));
            this.charts.setOption({
                series:[
                    {
                        label: {
                            normal:{
                                show:true,
                                formatter:'{b}:\n{c} ({d}%)',
                                align:'left',
                            },
                        },
                        tooltip:{
                            trigger:'item',
                        },
                        type:"pie",
                        data:[
                            {
                                value:this.countData[2].value,
                                name:"已收藏药物数",
                            },
                            {
                                value:this.countData[5].value,
                                name:"已收藏医师数",
                            },
                        ]
                    }
                ],
            })
        },
    }
}
</script>

<style lang="scss" scoped>
@import "~@/assets/scss/home.scss"
</style>