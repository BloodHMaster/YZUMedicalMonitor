<template>
    <el-container>
      <el-header>感谢小主指导，制作不易，跪求五星好评</el-header>
      <el-main>
        <div class = "container">
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
              <el-form-item label="姓名" prop="name">
              <el-input v-model="ruleForm.name"></el-input>
              </el-form-item>

            <el-form-item label="性别" prop="sex">
              <el-radio-group v-model="ruleForm.sex">
              <el-radio label="男"></el-radio>
              <el-radio label="女"></el-radio>
              <el-radio label="未知">未知</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item label="年龄" prop="age">
              <el-input v-model="ruleForm.age"></el-input>
            </el-form-item>

            <el-form-item label="联系电话" prop="phone">
              <el-input v-model="ruleForm.phone"></el-input>
            </el-form-item>

            <el-form-item label="邮箱" prop="email">
              <el-input v-model="ruleForm.email"></el-input>
            </el-form-item>
            
            <el-form-item label="是否愿意回访" prop="delivery">
              <el-switch
                style="display: block"
                v-model="ruleForm.delivery"
                active-color="#13ce66"
                inactive-color="#ff4949"
                active-text="同意回访"
                inactive-text="拒绝回访">
              </el-switch>
            </el-form-item>
        
            <el-form-item label="星级评价" prop="star">
              <el-rate
                v-model="ruleForm.value"
                show-text>
              </el-rate>
            </el-form-item>

            <el-form-item label="问题类型" prop="question">
              <el-radio-group v-model="ruleForm.question">
              <el-radio label="操作问题"></el-radio>
              <el-radio label="功能问题"></el-radio>
              <el-radio label="信息问题"></el-radio>
              <el-radio label="其他问题"></el-radio>
              </el-radio-group>
            </el-form-item>

             <el-form-item label="系统评价" prop="type">
              <el-checkbox-group v-model="ruleForm.type">
              <el-checkbox label="操作困难" name="type"></el-checkbox>
              <el-checkbox label="信息错误" name="type"></el-checkbox>
              <el-checkbox label="功能缺失" name="type"></el-checkbox>
              <el-checkbox label="界面糟糕" name="type"></el-checkbox>
              <el-checkbox label="其他体验不行" name="type"></el-checkbox>
              </el-checkbox-group>
              
            </el-form-item>

            <el-form-item label="意见反馈" prop="desc">
              <el-input 
                type="textarea" 
                v-model="ruleForm.desc"
                placeholder="请输入内容"
                maxlength="30"
                show-word-limit
                ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button :plain="true" @click='open1'>提交反馈</el-button>
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </div>
        
      </el-main>
      <el-footer>《最终解释权归开发组所有》</el-footer>
</el-container>
</template>

<script>
  export default {
     data() {
      return {
        ruleForm: {
          name: '',
          sex:'',
          age:'',
          phone:'',
          email:'',
          value:null,
          star:'',
          delivery: true,
          type: [],
          question: '',
          desc: ''
        },
        rules: {
          name: [
            { required: true, message: '请输入姓名', trigger: 'blur' },
          ],
          sex: [
            { required: true, message: '请选择性别', trigger: 'change' }
          ],
          age:[
             { required: true, message: '请输入年龄', trigger: 'blur' }
          ],
          phone:[
             {required: true, message: '请输入手机号', trigger: 'blur'},
             {pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/, message: '请输入正确的手机号', trigger: 'blur'}
          ],
          email:[
            {required: true, message: '请输入邮箱', trigger: 'blur'},
            {pattern: /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/, message: '请输入正确的邮箱', trigger: 'blur'}
          ],
          star: [
            { required: true, message: '请评价星级', trigger: 'change' }
          ],
          question:[
            { required: true, message: '请选择问题类型', trigger: 'change' }
          ],
          type: [
            { type: 'array', required: true, message: '请至少选择一个评价', trigger: 'change' }
          ],
          desc: [
            { required: true, message: '请填写问题反馈', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      open1() {
        this.$message({
          message: '反馈已收到，管理员正在赶往加班的路上...',
          type: 'success'
        });
      },
    submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
 
</script>


<style scoped>
  

  .el-header {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-footer{
      background-color: #B3C0D1;
      color: #333;
      text-align: center;
      line-height: 60px;
  }
  .el-main
  {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  .container{
    padding:0 20% 0 20%
  }

  .el-form
  {
    border: 1px #333;
  }
</style>