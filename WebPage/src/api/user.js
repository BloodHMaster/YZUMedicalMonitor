import request from '@/utils/request'

export function loginVerify(data) {
  return request({
    url: '/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/YDUser/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}

export function register(data){
  return request({
    url:'/YDUser/insertSelective',
    method:'post',
    data
  })
}

export function forgetPassword(data){
  return request({
    url:'',
    method:'post',
    data,verify
  })
}