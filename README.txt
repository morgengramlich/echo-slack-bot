Инструкции по установке и запуску бота:

Пререквизиты:
1) Gradle
2) Аккаунт в Slack с workspace
3) Публичный адрес по которому будет доступен сервер (можно использовать ngrok)

I. Создание приложения в Slack
  1) Перейдите на https://api.slack.com -> Your Apps -> Create New App
    - укажите имя приложения, например, echo-bot
    - выберите workspace в котором будет функционировать бот
  2) В списке слева выберите Bot Users -> Add a Bot User
  3) В списке выберите OAuth & Permissions -> Install App to Workspace; после этого на странице появится токен для бота, его нужно будет использовать ниже в настройках приложения

II. Настройка и запуск приложения
  1) Сделайте checkout репозитория
  2) Создайте файл с настройками application.properties; в файле укажите 2 параметра:
    - bot.endpoint=https://slack.com/api/
    - bot.token=<токен полученный в пункте I.3>
  3) соберите приложение командой gradle build
  4) запустите приложение командой:
    java -jar build/libs/echo-slack-bot-0.0.1-SNAPSHOT.jar --spring.config.location=file:<путь до>/application.properties 

  5) Вернитесь на страницу приложения в Slack, из списка слева выберите Event Subscriptions и активируйте опцию
  6) Укажите Request URL: <ваш публичный адрес>/mention
  7) В разделе Subscribe to Bot Events выберите событие app_mention

III. Добавьте бота в канал в вашем workspace’е, при упоминании имени бота, он ответит копией вашего сообщения.