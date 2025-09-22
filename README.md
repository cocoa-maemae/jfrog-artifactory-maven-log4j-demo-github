JFrog ArtifactoryとGitHub Actionsを連携したMavenプロジェクトのデモです。

脆弱性のあるlog4jライブラリを利用している

## セットアップ

### 前提条件

- Java 21
- Maven 3.6+
- JFrog Platform へのアクセス権限

### ローカルPCなど開発環境の設定

1. **settings.xml.templateをコピー**
   ```bash
   cp settings.xml.template ~/.m2/settings.xml
   ```

2. **認証情報を設定**
   `~/.m2/settings.xml`を編集して、以下の値を設定：
   - `your id`: JFrog Platformのユーザー名
   - `your api token`: JFrog PlatformのAPI Token

   ```xml
   <server>
     <id>artifactory</id>
     <username>your_actual_username</username>
     <password>your_actual_api_token</password>
   </server>
   ```

### ビルドとテスト

```bash
# 依存性のダウンロードとテスト実行
mvn clean test

# パッケージのビルド
mvn clean package

# アーティファクトのデプロイ（Artifactoryへ）
mvn clean deploy
```

## CI/CD

### GitHub Actions

このプロジェクトはGitHub Actions、JFrog CLIを使用してCIを実行します：

- **トリガー**: `main`と`dev`ブランチへのプッシュ/プルリクエスト
- **実行内容**:
  - Java 21以上でのビルド
  - テストの実行

### JFrog Artifactory設定

- **仮想リポジトリ**: `***-virtual`
- **ローカルリポジトリ**: `***-local`
- **リモートリポジトリ**: `***-remote`

## プロジェクト構成

```
src/
├── main/java/com/example/
│   ├── App.java              # メインアプリケーション
│   └── HelloService.java     # サービスクラス
└── test/java/com/example/
    └── HelloServiceTest.java # テストクラス
```
