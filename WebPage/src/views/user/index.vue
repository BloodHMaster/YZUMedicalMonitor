<template>
  <div class="user_info_contain">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="学校">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="学号">
        <el-input v-model="form.name"></el-input>
      </el-form-item>

      <el-form-item label="班级编号">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="学院">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="专业">
        <el-input v-model="form.name"></el-input>
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
      form: {
        name: "",
        region: "",
        date1: "",
        date2: "",
        delivery: false,
        type: [],
        resource: "",
        desc: "",
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