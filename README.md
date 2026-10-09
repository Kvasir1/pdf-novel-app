# PDF 소설 서재 (안드로이드 앱)

크랙에서 받은 PDF 를 넣어 두고, 인터넷 없이 폰에서 소설처럼 읽는 앱.

- 앱의 화면은 `app/src/main/assets/index.html` 한 벌이다 (글자 보기 · 원본 보기 · 서재 · 책갈피 · 찾기 · 이어 읽기).
- PDF 를 그리는 엔진(pdf.js 3.11.174)도 `assets/` 안에 있어 인터넷이 필요 없다. 인터넷 권한 자체를 두지 않았다.
- 넣은 PDF 와 책갈피는 앱의 저장 공간에 남는다. 앱을 지우면 같이 사라진다.

## 설치
1. 이 저장소의 **Releases** 에서 가장 새 `PDF-novel-shelf-v1.N.apk` 를 폰으로 내려받는다.
2. 내려받은 파일을 누르면 설치된다. 처음에는 「알 수 없는 앱 설치 허용」을 한 번 눌러야 한다.
3. 새 판이 나오면 같은 방법으로 덮어 설치하면 된다 (서재는 그대로 남는다).

## 조립
`main` 에 올리면 GitHub Actions 가 알아서 APK 를 조립해 Release 에 올린다. 손으로 돌리려면 Actions 탭 → 「APK 조립」 → Run workflow.

## 고치기
`index.html` 은 `작업\PDF 소설 앱\PDF 소설 서재.html` 과 같은 원본에서 나온다 (Claude 가 build.py 로 세 판을 만든다: claude.ai 게시판 · 파일로 여는 판 · 앱 판).
