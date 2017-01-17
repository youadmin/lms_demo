(defproject lms "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
	:dependencies [
		[org.clojure/clojure "1.8.0"]
		[ring/ring-defaults "0.1.5"]
		[ring/ring-anti-forgery "1.0.1"]
		[cheshire "5.5.0"]
		[org.clojure/data.xml "0.0.7"]
		[org.clojure/data.zip "0.1.1"]
		[compojure "1.4.0"]
		[org.clojure/java.jdbc "0.3.3"]
		[org.apache.tomcat/tomcat-jdbc "7.0.59"]
		[java-jdbc/dsl "0.1.0"]
		[org.clojure/tools.logging "0.3.1"]
		[org.clojure/tools.nrepl "0.2.11"]
		[org.clojure/data.json "0.2.6"]
		[mysql/mysql-connector-java "5.1.25"]
		[clj-time "0.9.0"]
		[clj-http "2.2.0"]
		[log4j/log4j "1.2.17" :exclusions [javax.mail/mail
																								javax.jms/jms
																								com.sun.jdmk/jmxtools
																								com.sun.jmx/jmxri]]
		[environ "1.0.0"]
		[buchner "0.1.0"]
	]
  :plugins [[lein-ring "0.9.7"]]
  :ring {
		:handler cart.handler/app
		:uberwar-name "cart"
	}
  :profiles
  {
		:dev {
			:dependencies [
					[javax.servlet/servlet-api "2.5"]
          [ring/ring-mock "0.3.0"]
					[midje "1.6.3"]
				]
			:jvm-opts ["-Dlogfile.path=development"]
			:env {
				:clj-env :development
				:clj-hostname "localhost"
				:clj-protocol "http"
				:clj-port "3000"
				:clj-db-properties "db.properties"
			}
		}
	:test {
			:dependencies [
					[javax.servlet/servlet-api "2.5"]
          [ring/ring-mock "0.3.0"]
					[midje "1.6.3"]
					[criterium "0.4.4"]
				]
			:jvm-opts ["-Dlogfile.path=development"]
			:env {
				:clj-env :development
				:clj-hostname "localhost"
				:clj-protocol "http"
				:clj-port "3000"
				:clj-db-properties "test_db.properties"
			}
		}
	 :production {
			:jvm-opts ["-Dlogfile.path=production"]
			:env {:clj-env :production}
		}
	})
