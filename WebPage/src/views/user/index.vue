<template>
  <div class="user_info_contain">
    <el-form model="Form" :rules="rules" ref="Form" label-width="80px">
      <el-form-item label="用户名" prop="account">
        <el-input v-model="Form.account"></el-input>
      </el-form-item>
      <el-form-item label="姓名" prop="name">
        <el-input v-model="Form.name" ></el-input>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input v-model="Form.age" ></el-input>
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-input v-model="Form.sex"></el-input>
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input v-model="Form.phone"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="Form.email"></el-input>
      </el-form-item>
      <el-form-item label="血型" prop="blood">
        <el-input v-model="Form.blood"></el-input>
      </el-form-item>
      <el-form-item label="身高" prop="height">
        <el-input v-model="Form.height"></el-input>
      </el-form-item>
      <el-form-item label="体重" prop:weight>
        <el-input v-model="Form.weight"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存修改</el-button>
        <!-- <el-button>取消</el-button> -->
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      Form: {
        account:'',
        name:'',
        age:'',
        sex:'',
        phone:'',
        email:'',
        blood:'',
        height:'',
        weight:'',
      },
      
    };
  },
  methods: {
    onSubmit() {
      console.log("submit!");
    },
  },
};
</script>


<style lang="scss">
.user_info_contain {
  padding: 50px;
}
</style>