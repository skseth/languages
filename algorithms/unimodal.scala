


first = n[0]
second = n[1]

if second < first : swap -- 1 comparison


for i = 2; i < l; i++ {
  cur = n[i]

  if cur[i] > first {
      second = first
      first = cur[i]
  }
  else if cur[i] > second {
    second = cur[i]
  }
}


