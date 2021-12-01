import defaultSettings from '@/settings'

const title = defaultSettings.title || 'YD 编程'

export default function getPageTitle(pageTitle) {
  if (pageTitle) {
    return `${pageTitle} - ${title}`
  }
  return `${title}`
}
