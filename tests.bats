#!/usr/bin/env bats
#
# kanjinumbers を HTTP 経由でテストするサンプル
#
# bashスクリプトでテストケースを記述する bats を利用している。
# Mac環境では、brew install bats でインストールできる。
# CentOSでは、epelリポジトリに含まれており、yum install bats でインストールできる。
#

BASEURL="http://localhost:8080"

@test "零" {
  run curl -Ss "${BASEURL}/v1/number2kanji/0"
  [ "${output}" = "零" ]
}
@test "壱" {
  run curl -Ss "${BASEURL}/v1/number2kanji/1"
  [ "{output}" = "壱" ]
}
