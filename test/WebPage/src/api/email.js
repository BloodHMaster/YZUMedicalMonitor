import request from '@/utils/request'

export function sendEmail(params) {
    return request({
      url: '/email',
      method: 'post',
      params
    })
  }
  