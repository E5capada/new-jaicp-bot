require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет
        random:
            a: Привет! 
            a: Здравствуйте!

    state: bye
        intent!: /пока
        a: Пока пока

    state: /NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали
        
    state: Match
        event!: match
        a: {{$context.intent.answer}}    

    
    state: weather
        q!: * (*прогноз*/погод*/сводка) *
        a: уточняю погоду
        
        state: weather
            q!: * (~дождь/~снег/~солнце/~ветер) *
            a: уточняю погоду для {{$request.query}}
        
    
    state: currency
        q!: * (курс*/валют*) * 
        a: Узнаю курс валют
        
        state: currencyEvro
        q: * (евро/доллар*/рубл*) * 
        