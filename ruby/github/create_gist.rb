require 'octokit'
require 'dotenv'
require 'csv'
require 'json'

Dotenv.load
token = ENV['TOKEN']
github = Octokit::Client.new access_token: token

module CSVConvertible
  def to_csv(*keys)
    keys = self.map(&:keys).inject([], &:|) if keys.empty?
    CSV.generate do |csv|
      csv << keys
      self.each { |hash| csv << hash.values_at(*keys) }
    end
  end
end

json = <<EOS
{
  "hoge": [
      {
          "id": 1,
          "name": "alice"
      },
      {
          "id": 2,
          "name": "bob"
      }
  ]
}
EOS

res = JSON.parse(json)
hoges = res['hoge'].extend(CSVConvertible)
content = hoges.to_csv
options = {description: 'test gist', public: false, files: {'test.csv': {content: content}}}

ret = github.create_gist options
p ret['html_url']
