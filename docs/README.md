# 🚀 구현 기능 목록

## ✅ 식당 예상 방문 날짜를 입력 받는다.
    - 방문할 날짜는 1 이상 31 이하의 숫자
    🚨 예외 상황: 입력값 오류(InputException)
      - ✅ 입력값이 숫자가 아닐 시에 에러 메시지 출력 후 재입력.
    🚨 예외 상황: 도메인 오류(EventPlannerException)
      - ✅ 1 이상 31 이하의 숫자가 아닐 시에 에러 메시지 출력 후 재입력.
## ✅ 주문할 메뉴와 개수를 입력 받는다.
    - 음료만 주문은 불가하다.
    - 메뉴는 한 번에 최대 20개까지만 주문할 수 있다.
    🚨 예외 상황: 입력값 오류(InputException)
      - ✅ 1 이상의 숫자가 아닌 메뉴의 개수를 입력하는 경우 에러 메시지 출력 후 재입력.
      - ✅ 메뉴 형식이 예시와 다른 경우 에러 메시지 출력 후 재입력.
    🚨 예외 상황: 도메인 오류(EventPlannerException)
      - ✅ 고객이 메뉴판에 없는 메뉴를 입력하는 경우 에러 메시지 출력 후 재입력.
      - ✅ 중복 메뉴를 입력한 경우 에러 메시지 출력 후 재입력
      - ✅ 주문 메뉴가 20개가 넘는 경우 에러 메시지 출력 후 재입력
## ✅ 방문 날짜에 받을 이벤트 혜택을 계산한다.
    - 크리스마스 디데이 할인을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용된다.
    - ✅ 총주문 금액 10000원 이상부터 이벤트가 적용된다.
    - ✅ 크리스마스 디데이 할인: 2023.12.1 ~ 2023.12.25
        - 1000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
        - 총주문 금액에서 해당 금액만큼 할인
    - ✅ 평일 할인: 일요일 ~ 목요일
        - 평일에는 디저트 메뉴를 1개당 2023원 할인
    - ✅ 주말 할인: 금요일, 토요일
        - 주말에는 메인 메뉴를 1개당 2023원 할인
    - ✅ 특별 할인
        - 이벤트 달력에 별이 있으면 총주문 금액에서 1000원 할인
    - ✅ 증정 이벤트
        - 할인 전 총 주문금액이 12만원 이상일 때, 샴페인 1개를 증정한다.
## [x] 방문 날짜에 받을 이벤트 혜택을 출력한다.
    - ✅ 주문 메뉴를 출력한다.
        - 주문 메뉴의 출력 순서는 자유롭게 출력한다.
    - ✅ 할인 전 총주문 금액을 출력한다.
    - ✅ 증정 메뉴를 출력한다.
        - 증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 보여준다.
    - ✅ 혜택 내역을 출력한다.
        - 고객에게 적용된 이벤트 내역만 보여준다.
        - 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 보여준다.
        - 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게 출력한다.
    - ✅ 총혜택 내역을 출력한다.
        - 혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
    - ✅ 할인 후 예상 결제 금액을 출력한다.
        - 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액
    - ✅ 12월 이벤트 배지를 출력한다.
        - 총 혜택금액에 따라 이벤트 배지의 이름을 다르게 보여준다.
        - 5천 원 이상: 별
        - 1만 원 이상: 트리
        - 2만 원 이상: 산타


